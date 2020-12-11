# Tutorial APAP
## Authors
* **Rifqi Hilman Saputra** - *1806191313* - *APAP-A*
---
## Tutorial 1
### What I have learned today
*Saya belajar cukup banyak mengenai APAP. Seperti penggunaan Github dan Spring. Selain itu juga belajar menggunakan @RequestParam dan @PathVariable.*
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue Tracker digunakan untuk mengumpulkan user feedback, melaporkan ketika ada bug dan masalah-masalah lainnya yang mungkin dapat terjadi. Dalam setiap issue juga terdapat label yang memudahkan pengelompokan. Masalah-masalah yang dapat diselesaikan diantaranya adalah request feature baru, error pada feature, pull request dan yang lainnya
2. Apa perbedaan dari git merge dan git merge --squash?
git merge dilakukan ketika ingin merge 2 branch, sedangkan git merge --squash adalah semua perubahan yang terjadi digabung menjadi 1 dan muncul sebagai 1 commit
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?
Dengan menggunakan Version Control System, akan mempermudah untuk para pengembang karena sistem tersebut akan menyimpan file atau kumpulan file yang telah dibuat dan melihat perbedaan yang ada. Selain itu juga dapat diakses oleh berbeda developer meskipun dalam 1 project yang sama. 

### Spring
4. Apa itu library & dependency?
Library adalah kode-kode yang sudah disedakan, dalam hal kali ini disediakan oleh Spring untuk membantu user. User hanya perlu import apa saja yang diperlukan.
Dependency merupakan sebuah service yang diberikan oleh Spring yang dapat digunakan sesuai kebutuhan program kita yang ingin dibuat.
5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Karena Maven dapat menambahkan semua dependencies yang dibutuhkan secara otomatis dengan membaca pom file, selain itu untuk menambahkan dependency juga mudah hanya dengan menuliskan codenya di pom. Selain Maven, yang dapat digunakan salah satunya adalah Gradle
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Spring Framework dapat digunakan untuk membuat mobile app
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?
Perbedaan dari @RequestParam dan @PathVariable terletak pada keyword yang terdapat di URL. Menggunakan @RequestParam sebaiknya untuk parameter query (statis) sedangkan @PathVariable untuk parameter dinamis dan juga untuk mengekstrak data langsung dari URI 

### What I did not understand
- [ ] Saya masih belum mengerti mengenai fungsi dari model dan controller lebih dalam
- [ ] Saya masih belum mengerti file seperti apa yang dimasukkan ke package model maupun controller

---
## Tutorial 2
### What I have learned today
*Saya belajar banyak pada Tutorial kali ini terutama belajar mengenai penggunaan MVC*
1. Terjadi Internal Server Error 500 karena belum memiliki templates/HTML
2. @Autowired merupakan anotasi yang disediakan oleh Spring. Constructor, field, setter dapat dibuat secara langsung sehingga dapat mengurangi volume konfigurasi yang diperlukan. @Autowired juga dapat membuat konfigurasi up-to-date. Contohnya ketika menambahkan dependency ke sebuah class, dependensi dapat dipenuhi secara otomatis tanpa perlu konfigurasi
3. Terjadi error karena ketika ingin menambahkan hotel, terdapat 4 parameter yang harus dimasukkan yaitu id, nama, alamat dan nomor telepon. Pada pertanyaan tersebut tidak terdapat nomor telepon pada URL sehingga terjadi error
4. Mengakses link berikut ini: http://localhost:8080/hotel/view?idHotel=1
5. Berikut hasilnya 
![no5](https://user-images.githubusercontent.com/60379157/94827810-0fcf0200-0433-11eb-919e-fcbed67d62da.jpg)

### What I did not understand
- [ ] Saya masih belum mengerti perbedaan @RequestMapping dengan @GetMapping

---
## Tutorial 3
### What I have learned today
*Saya belajar penggunaan database pada Spring Framework*
1. Method tersebut berguna untuk mengembalikan list dari class HotelModel. Method tersebut akan mencari kamar yang sesuai dengan id dari objek HotelModel dan mengembalikannya dalam bentuk list
2. addHotelFormPage akan menampilkan form untuk diisi oleh user untuk menambahkan hotel sesuai dengan field-field yang ada. Sedangakan addHotelSubmit akan mengambil apa yang user isi dan juga sebagai penanda kalau hotel berhasil ditambahkan
3. JPA sendiri adalah merupakan suatu cara standar untuk memasukkan data ke dalam relational database. JPA Repository berguna untuk mempermudah dan menghemat waktu.
4. Terdapat @OneToMany di HotelModel dan @ManyToOne di KamarModel yang menunjukkan hubungan relasi dari kedua class.
5. FetchType.LAZY digunakan ketika kita ingin melakukan fetch data ketika dibutuhkan atau dipanggil dengan suatu method. CascadeType.ALL adalah melakukan semua perubahan untuk suatu entity. Perubahan-perubahan yang dapat dilakukan seperti persist, remove, refresh dan merge. FetchType.EAGER adalah fetch data dilakukan secepatnya dan akan load semua relationship 

### What I did not understand
- [ ] Saya belum mengerti penggunaan @PostMapping

---
## Tutorial 4
### What I have learned today
*Saya belajar mengenai penggunaan Thymeleaf lebih lanjut*
1. th:include akan memasukan semua content yang ada di fragment ke dalam tag yang akan dimasukkan. Sedangkan th:replace akan menggantikan isi dari tag dengan fragment.
2. th:object digunakan untuk menentukan object yang akan menjadi tempat suatu form data yang akan disubmit.
3. $ dapat digunakan kapan saja, karena $ merupakan ekspresi atau syntax yang umum. Sedangkan * melakukannya pada objek yang dipilih, bukan pada keseluruhan.
4. Pada latihan nomor 3, saya membuat tag anchor baru yang akan direct ke # dengan nama {title}. {title} tersebut akan berubah sesuai page yang sedang dibuka. Saya menambahkan (title='Nama Page yang Dibuka') pada setiap halaman disesuaikan dengan page yang sedang dibuka. Penambahan tersebut saya buat berada di tag nav yang ada di semua html yang.

### What I did not understand
- [ ] Saya belum mengerti syntax yang terdapat di contoh html untuk delete kamar yang berada di view-hotel

---
## Tutorial 5
### What I have learned today
*Saya belajar mengenai API*
1. Postman merupakan sebuah tool yang digunakan untuk membedah Restful API, baik yang dibuat oleh orang lain maupun yang kita buat. Postman dapat digunakan untuk Testing API, GUI App Caller dan yang lainnya
2. @JsonIgnoreProperties digunakan untuk mengabaikan properties dalam Json serialization dan deserialization, serta digunakan pada class level. Sedangkan @JsonIgnore digunakan pada field level untuk menandakan property atau kumpulan properti yang ingin diabaikan
3. WebClient merupakan sebuah komponen/interface Web Reactive Framework. Kegunaannya adalah akan membantu membangun sebuah aplikasi web yang reaktif dan non-pemblokiran
4. ResponseEntity merepresentasikan HTTP Response, termasuk header, body, status. Kegunaannya adalah kita dapat melakukan konfigurasi penuh terhadap HTTP Response. BindingResult akan menyimpan hasil validasi dan pengikatan dan kesalahan yang mungkin terjadi. BindingResult harus muncul tepat setelah objek model divalidasi atau Spring gagal untuk memvalidasi objek tersebut dan akan throw exception. 
### What I did not understand
- [ ] Saya belum mengerti kegunaan dari example

---
## Tutorial 6
### What I have learned today
*Saya belajar mengenai Web Security*
1. Otentikasi adalah sebuah proses untuk memverifikasi. Verifikasi dilakukan dengan memasukkan username dan password yang sesuai. Implementasi pada code adalah saat melakukan login. Sedangkan, otorisasi adalah sebuah proses apakah seseorang memiliki akses/izin terhadap sesuatu. Implementasi pada code adalah di WebSecurityConfig dimana hanya ADMIN yang dapat menambahkan user baru.
2. BCryptPasswordEncoder adalah sebuah fungsi/tool yang digunakan untuk hashing pada password. Setiap kali dipanggil, BCryptPasswordEncoder akan melakukan encoding dengan memanfaatkan hashing agar keamanan password terjamin.
3. UUID adalah sekumpulan karakter yang terdiri dari 32 karakter dan 4 tanda hubung. UUID pasti unik untuk setiap data dan dapat digunakan untuk Primary Key. UUID juga dapat meningkatkan keamanan karena karakter yang ada pada UUID random.
4. UserDetailsServiceImpl.java berguna dalam otentikasi dan otorisasi. Dalam class tersebut mengextends UserServiceDetail yang akan berisi object yang didapatkan dari database dan melakukan otorisasi sesuai role.  
### What I did not understand
- [ ]

---
## Tutorial 7
### What I have learned today
*Saya belajar mengenai React*
1. Pada latihan nomor 1, saya menambahkan code berikut ini yang bertujuan agar checkbox di bagian kiri hilang

![1](https://user-images.githubusercontent.com/60379157/101024863-4e09ae80-35a7-11eb-8698-0b6fedbf778b.jpg)

Hasilnya adalah sebagai berikut

![2](https://user-images.githubusercontent.com/60379157/101024951-6e396d80-35a7-11eb-938f-77dcedb13337.jpg)

Pada latihan nomor 2, saya menambahkan boolean isActive: false

![3](https://user-images.githubusercontent.com/60379157/101025031-8c06d280-35a7-11eb-95ba-fe638f9f534b.jpg)

Lalu saya juga membuat event handler yang ketika diklik akan menghapus list favorite 
![4](https://user-images.githubusercontent.com/60379157/101025138-b6589000-35a7-11eb-84f8-58a3154c334f.jpg)

Saya juga setState dengan menunjukkan bahwa isActive = true yang membuat button akan muncul saat klik film di bagian kiri

![5](https://user-images.githubusercontent.com/60379157/101025283-f3248700-35a7-11eb-8b72-c684f8437867.jpg)

Selanjutnya saya membuat button yang akan berfungsi sesuai dengan yang sudah dibuat, dimana ketika isActive = false, akan menghasilkan null dan button akan hilang

![6](https://user-images.githubusercontent.com/60379157/101025460-3121ab00-35a8-11eb-8ddd-c022fd8b286d.jpg)

Hasilnya akan menjadi seperti ini, kondisi ini adalah ketika belum klik film dan button delete tidak ada

![7](https://user-images.githubusercontent.com/60379157/101025657-77770a00-35a8-11eb-8960-c0f5a97fcf5b.jpg)

Ini kondisi ketika film sudah diklik dan akan muncul button Delete

![8](https://user-images.githubusercontent.com/60379157/101025661-7940cd80-35a8-11eb-8dd2-d0c8f6af99af.jpg)

Pada latihan nomor 3, saya membuat event handler untuk list movies dan list favorite sebagai berikut ini dimana pada handler untuk list movies, tidak terdapat method splice yang dapat menghapus item dan handler untuk list favorite sama seperti tutorial ini

![5](https://user-images.githubusercontent.com/60379157/101025283-f3248700-35a7-11eb-8b72-c684f8437867.jpg)

![16](https://user-images.githubusercontent.com/60379157/101026543-9b871b00-35a9-11eb-828f-0ff8e304eeac.jpg)

Lalu, event handler tersebut akan dipanggil

![15](https://user-images.githubusercontent.com/60379157/101026540-9aee8480-35a9-11eb-8e5e-f0a540dd51c0.jpg)

![17](https://user-images.githubusercontent.com/60379157/101026549-9cb84800-35a9-11eb-9222-03e5ec342a0d.jpg)

Pada latihan nomor 4, saya membuat toggle berupa checkbox yang ketika diklik akan menampilkan list favorite. Saya membuat boolean favList: false

![3](https://user-images.githubusercontent.com/60379157/101025031-8c06d280-35a7-11eb-95ba-fe638f9f534b.jpg)

Lalu saya membuat event handler untuk menampilkan list favorite

![11](https://user-images.githubusercontent.com/60379157/101025825-b1481080-35a8-11eb-892b-bcc91798f6aa.jpg)

Saya juga menambahkan favList

![12](https://user-images.githubusercontent.com/60379157/101026528-988c2a80-35a9-11eb-8562-5c095b479f97.jpg)

Selanjutnya saya membuat kondisi ketika favList true, maka akan menampilkan list favorite dan tidak menampilkan list favorite jika bernilai false

![13](https://user-images.githubusercontent.com/60379157/101026534-99bd5780-35a9-11eb-8493-b0ff8698c2dc.jpg)

Hasilnya adalah sebagai berikut 

![10](https://user-images.githubusercontent.com/60379157/101025820-af7e4d00-35a8-11eb-9ff5-bd82ed21194b.jpg)

![9](https://user-images.githubusercontent.com/60379157/101025826-b1e0a700-35a8-11eb-8e4d-9da15be5e4c2.jpg)

Pada latihan nomor 5, saya membuat component baru yaitu EmptyState

![14](https://user-images.githubusercontent.com/60379157/101026536-9a55ee00-35a9-11eb-8ee8-d8e4720ecc11.jpg)

Lalu saya juga menambahkan kondisi ketika favItems lebih dari 0, maka akan menampilkan isi dari list tersebut, jika tidak lebih dari 0 atau tidak ada isinya maka akan menampilkan EmptyState yang telah dibuat
![18](https://user-images.githubusercontent.com/60379157/101029148-8ca16800-35ab-11eb-9b40-2ff4d07c5393.jpg)

Hasilnya adalah sebagai berikut
![9](https://user-images.githubusercontent.com/60379157/101025826-b1e0a700-35a8-11eb-8e4d-9da15be5e4c2.jpg)

2. Props adalah variable yang akan dipass dari component parentnya. Sedangkan state adalah variable/tempat penyimpanan yang diinisialisasi dan dimanage oleh component itu sendiri.
3. Keuntungan yang didapatkan adalah reusable. Component-component yang dibuat terpisah dapat disusun menjadi satu kesatuan. Contohnya adalah pada tutorial ini membuat component secara terpisah yaitu Item dan List yang dapat digunakan sesuai dengan kebutuhannya
4. Kelebihan dari React adalah reusable, efisien dan juga memiliki performance yang bagus
5. Kekurangan dari React adalah syntax yang terkadang membingungkan karena menggabungkan JSX syntax untuk membuat Javascript object dengan syntax HTML selain itu sulit untuk dipahami apabila baru pertama kali mengembangkan web

### What I did not understand
- [ ] Saya masih harus mempelajari React lebih lanjut agar terbiasa dengan syntaxnya

---
## Tutorial 8
### What I have learned today
*Saya belajar lebih mengenai React*
1. Saya set state namaHotel, alamat dan noTelepon menjadi "" pada handleSubmitHotel. Hal tersebut membuat value yang telah diisi melalui form akan kembali kereset menjadi kosong
2. Async akan mendefinisikan asynchronous function yang akan mereturn AsyncFunction objek/pasti mereturn sesuatu dan dapat menjalankan suatu fungsi secara bersamaan. Sedangkan await hanya akan ada di dalam fungsi async. Kita menggunakan await ketika ingin fetch data dari server dan menggunakan data tersebut dalam async. Lalu, await akan menghentikan eksekusi fungsi secara sementara dan menjalankannya kembali setelah datanya sudah ada.
3. 
![Screenshot (1003)](https://user-images.githubusercontent.com/60379157/101915956-e1229400-3bf8-11eb-8c27-14f6c358b82c.png)

![Screenshot (1006)](https://user-images.githubusercontent.com/60379157/101916065-031c1680-3bf9-11eb-8ae9-c41b4e692861.png)

![Screenshot (1007)](https://user-images.githubusercontent.com/60379157/101916057-00b9bc80-3bf9-11eb-8f5f-fff0ce84bbf8.png)

4. componentDidMount: akan dieksekusi setelah render pertama selesai. Selain itu juga dapat digunakan untuk mengintegrasikan dengan framework JavaScript lain. Kita menggunakannya ketika ingin update state

shouldComponentUpdate: akan return true atau false dan menentukan apakah component akan diupdate atau tidak

componentDidUpdate: akan dipanggil setelah terjadi pembaruan

componentWillReceiveProps: akan dipanggil setelah props diupdate sebelum render selanjutnya dipanggil

componentWillUnmount: akan dipanggil ketika component dihapus dari DOM

### What I did not understand
- [ ]