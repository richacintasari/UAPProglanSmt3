# Reservasi Poli

Reservasi Poli adalah aplikasi berbasis Java dengan antarmuka grafis yang memungkinkan pengguna untuk melakukan reservasi poli kesehatan seperti Poli Gigi, Poli Kandungan, dan Poli Umum. Aplikasi ini menggunakan **Swing** untuk membuat GUI sederhana dan intuitif.

## Fitur Utama

1. **Input Data Pasien:**
    - Pengguna dapat memasukkan nama, tanggal reservasi, dan memilih poli yang diinginkan.
    - Validasi dilakukan untuk memastikan format tanggal dan nama sesuai dengan aturan.

2. **Pemisahan Data Berdasarkan Poli:**
    - Data pasien ditampilkan dalam tabel berbeda berdasarkan poli yang dipilih.
    - Tabel dilengkapi dengan nomor antrian otomatis.

3. **Validasi Input:**
    - Nama harus berisi alfabet saja.
    - Tanggal harus sesuai dengan format **dd/MM/yyyy**.

4. **Tampilan Tabel:**
    - Tabel berbeda untuk setiap poli:
        - Poli Gigi (background abu-abu terang)
        - Poli Kandungan (background pink)
        - Poli Umum (background kuning)

## Cara Penggunaan

1. Jalankan aplikasi dengan menjalankan file `ReservasiPoli`.
2. Isi kolom **Nama**, **Tanggal (dd/MM/yyyy)**, dan pilih poli dari dropdown.
3. Klik tombol **Tambahkan Antrian** untuk menambahkan data ke tabel yang sesuai.
4. Data akan otomatis ditampilkan di tabel berdasarkan poli yang dipilih.

## Struktur Program

### Komponen Utama
- **Input Panel:**
    - TextField untuk nama dan tanggal.
    - ComboBox untuk memilih poli.
    - Button untuk menambahkan data.

- **Table Panel:**
    - Tabel untuk masing-masing poli (Poli Gigi, Poli Kandungan, Poli Umum).

### Validasi
- **Nama:** Hanya boleh berisi alfabet (a-z, A-Z).
- **Tanggal:** Harus sesuai dengan format dd/MM/yyyy.
- **Poli:** Harus dipilih salah satu dari opsi yang tersedia.

### Error Handling
- Jika input tidak valid, pengguna akan menerima pesan kesalahan melalui dialog pop-up.

## Teknologi yang Digunakan
- **Java SE 8+**
- **Swing** untuk antarmuka pengguna

## Contoh Screenshot (Opsional)
- Tabel terpisah berdasarkan poli.
- Validasi input yang memberikan feedback kepada pengguna.

## Kontributor
Program ini dikembangkan oleh [Levina, Richa].

