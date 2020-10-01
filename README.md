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


   