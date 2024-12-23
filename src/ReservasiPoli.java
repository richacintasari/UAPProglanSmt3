import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class ReservasiPoli extends JFrame {
    private JTextField namaField;
    private JTextField tanggalField;
    private JComboBox<String> poliComboBox;
    private JTable gigiTable, kandunganTable, umumTable;
    private DefaultTableModel gigiModel, kandunganModel, umumModel;

    public ReservasiPoli() {
        setTitle("Reservasi Poli");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        namaField = new JTextField(15);
        tanggalField = new JTextField(10);
        String[] poliOptions = {"Pilih Poli", "Poli Gigi", "Poli Kandungan", "Poli Umum"};
        poliComboBox = new JComboBox<>(poliOptions);
        JButton tambahButton = new JButton("Tambahkan Antrian");

        inputPanel.add(new JLabel("Nama:"));
        inputPanel.add(namaField);
        inputPanel.add(new JLabel("Tanggal (dd/MM/yyyy):"));
        inputPanel.add(tanggalField);
        inputPanel.add(new JLabel("Poli:"));
        inputPanel.add(poliComboBox);
        inputPanel.add(tambahButton);

        // Table Panel
        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new GridLayout(1, 3));

        // Tabel untuk Poli Gigi
        gigiModel = new DefaultTableModel(new String[]{"No", "Nama", "Tanggal"}, 0);
        gigiTable = new JTable(gigiModel);
        gigiTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
        gigiTable.setBackground(Color.LIGHT_GRAY);
        tablePanel.add(new JScrollPane(gigiTable));

        // Tabel untuk Poli Kandungan
        kandunganModel = new DefaultTableModel(new String[]{"No", "Nama", "Tanggal"}, 0);
        kandunganTable = new JTable(kandunganModel);
        kandunganTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
        kandunganTable.setBackground(Color.PINK);
        tablePanel.add(new JScrollPane(kandunganTable));

        // Tabel untuk Poli Umum
        umumModel = new DefaultTableModel(new String[]{"No", "Nama", "Tanggal"}, 0);
        umumTable = new JTable(umumModel);
        umumTable.setPreferredScrollableViewportSize(new Dimension(200, 100));
        umumTable.setBackground(Color.YELLOW);
        tablePanel.add(new JScrollPane(umumTable));

        // Menambahkan panel ke frame
        add(inputPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);

        // Action Listener untuk tombol
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nama = namaField.getText().trim();
                    if (nama.isEmpty()) {
                        throw new Exception("Kolom nama tidak boleh kosong.");
                    }
                    if (!isAlphabet(nama)) {
                        throw new Exception("Nama hanya boleh mengandung alfabet.");
                    }

                    String tanggal = tanggalField.getText().trim();
                    if (tanggal.isEmpty()) {
                        throw new Exception("Kolom tanggal tidak boleh kosong.");
                    }
                    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(tanggal);

                    String poli = (String) poliComboBox.getSelectedItem();
                    if (poli.equals("Pilih Poli")) {
                        throw new Exception("Silakan pilih poli.");
                    }

                    // Menambahkan data ke tabel yang sesuai
                    if (poli.equals("Poli Gigi")) {
                        gigiModel.addRow(new Object[]{gigiModel.getRowCount() + 1, nama, new SimpleDateFormat("dd/MM/yyyy").format(date)});
                    } else if (poli.equals("Poli Kandungan")) {
                        kandunganModel.addRow(new Object[]{kandunganModel.getRowCount() + 1, nama, new SimpleDateFormat("dd/MM/yyyy").format(date)});
                    } else if (poli.equals("Poli Umum")) {
                        umumModel.addRow(new Object[]{umumModel.getRowCount() + 1, nama, new SimpleDateFormat("dd/MM/yyyy").format(date)});
                    }

                    // Reset input
                    namaField.setText("");
                    tanggalField.setText("");
                    poliComboBox.setSelectedIndex(0);

                } catch (ParseException ex) {
                    showError("Format tanggal salah. Gunakan format dd/MM/yyyy.");
                } catch (Exception ex) {
                    showError(ex.getMessage());
                }
            }
        });

        setVisible(true);
    }

    private boolean isAlphabet(String str) {
        return Pattern.matches("[a-zA-Z]+", str);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        new ReservasiPoli();
    }
}