/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import modelo.Cita;
import modelo.Cliente;
import modelo.Mascota;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 *
 * @author migue
 */
public class ClienteDao extends GeneralDao<ClienteDao>{
    private BufferedReader bufferedReader;

    public Cliente getClientFromPatient(String patientId){
        File file = Arrays.stream(this.getCarpetaPaciente().listFiles()).filter(file1 -> !file1.isDirectory() && file1.getName().endsWith(patientId + ".txt")).findFirst().orElse(null);
        if (file == null){
            // no existe el paciente
        }else{
            try {
                Cliente cliente = new Cliente();
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                String content = bufferedReader.lines().collect(Collectors.joining("\n"));

                String[] lines = content.split("\n");
                String client = lines[0];
                StringTokenizer tokenizer = new StringTokenizer(client, ":");
                String clientName = tokenizer.nextToken();

                cliente.setNombre(clientName);

                String mascotaNombre = tokenizer.nextToken();
                String mascotaPeso = tokenizer.nextToken();
                String mascotaRaza = tokenizer.nextToken();
                Mascota mascota = new Mascota(mascotaNombre, "12", mascotaRaza, mascotaPeso, patientId);

                for (int i = 1; i < lines.length; i++) {
                    String line = lines[i];
                    if (!line.isEmpty()){
                        StringTokenizer citaTokenizer = new StringTokenizer(line, ":");
                        String motivo = citaTokenizer.nextToken();
                        String nombreMedico = citaTokenizer.nextToken();
                        String fecha = citaTokenizer.nextToken();
                        Cita cita = new Cita(fecha, nombreMedico, motivo);
                        mascota.getCitas().add(cita);
                    }
                }
                cliente.setMascota(mascota);

                bufferedReader.close();
                return cliente;
            } catch (IOException e) {
                // no se puedo leer el archivo idk why
                e.printStackTrace();
            }
        }
        return null;
    }
}
