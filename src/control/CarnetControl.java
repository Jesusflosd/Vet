package control;

import DAO.ClienteDao;
import modelo.Cita;
import modelo.Cliente;
import vista.CarnetVista;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarnetControl implements ActionListener {

    private CarnetVista carnetVista;
    private ClienteDao clienteDao;

    public CarnetControl(CarnetVista carnetVista, ClienteDao clienteDao) {
        this.carnetVista = carnetVista;
        this.clienteDao = clienteDao;

        this.carnetVista.getjButton1().addActionListener(this);
    }

    public CarnetVista getCarnetVista() {
        return carnetVista;
    }

    public void setCarnetVista(CarnetVista carnetVista) {
        this.carnetVista = carnetVista;
    }

    public ClienteDao getClienteDao() {
        return clienteDao;
    }

    public void setClienteDao(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.carnetVista.getjButton1() == e.getSource()){
            String tID = this.carnetVista.getTid().getText();
            if (!tID.isEmpty()){
                Cliente client = clienteDao.getClientFromPatient(tID);

                if (client == null){
                    //no se encontro el mascota
                    return;
                }

                this.carnetVista.getNombreClient().setText(client.getNombre());
                this.carnetVista.getNombreMascota().setText(client.getMascota().getNombre());
                this.carnetVista.getTraza().setText(client.getMascota().getRaza());

                this.carnetVista.getTabCitas().setModel(new DefaultTableModel(client.getMascota().getCitas().size(), 3){
                    final String[] columnNames = {"Nombre Medico", "Motive", "Fecha"};
                    @Override
                    public String getColumnName(int column) {
                        return columnNames[column];
                    }
                });
                for (int i = 0; i < client.getMascota().getCitas().size(); i++) {
                    Cita cita = client.getMascota().getCitas().get(i);
                    this.carnetVista.getTabCitas().setValueAt(cita.getNombreMedico(), i, 0);
                    this.carnetVista.getTabCitas().setValueAt(cita.getMotivo(), i, 1);
                    this.carnetVista.getTabCitas().setValueAt(cita.getFecha(), i, 2);
                }

            }else{
                //nel...
            }
        }
    }
}
