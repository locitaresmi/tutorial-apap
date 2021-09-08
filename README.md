
# Tutorial APAP

## Authors

* **Wening Dyah Locitaresmi** - *1906299194* - *B*

## [Tutorial 1](https://scele.cs.ui.ac.id/pluginfile.php/120294/mod_resource/content/2/Tutorial%201%20%28A%2C%20B%2C%20C%29.pdf)

### What I have learned today :blush:

### 1. GitHub

1. Apa itu **Issue Tracker**? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?

	Issue Tracker (atau Bug Tracker) adalah sistem terintegrasi yang berfungsi untuk mendokumentasikan/mencatat permasalahan yang dialami pengguna  ketika menggunakan suatu aplikasi. Sistem ini memungkinkan sesama developer untuk memantau perkembangan suatu permasalahan yang dialami oleh pengguna hingga permasalahan tersebut berhasil diatasi (sejak permasalahan di-open hingga di-close). Adapun contoh permasalahan yang dimaksud adalah sebagai berikut.
	
	- Bug pada aplikasi. Misalnya, pengguna tidak bisa log in pada aplikasi meskipun data yang di-input sudah benar;
	- Kesalahan pada alur program. Misalnya, alur yang sudah dibuat tidak sesuai dengan requirements yang diberikan; dan
	- lainnya.
	
	Selain permasalahan, Issue Tracker juga dapat dimanfaatkan untuk melakukan tracking terhadap feedback dari pengguna terhadap pengembangan software. Salah satu contohnya yaitu untuk perbaikan UX.

2. Apa perbedaan dari **git merge** dan **git merge --squash**?

	Perbedaan keduanya terletak pada metadata dari commit history. Saat membuat branch untuk pembuatan fitur baru, tidak jarang seorang developer melakukan commit hingga berulang kali. 

	Ketika menggunakan git merge untuk menggabungkan branch tersebut dengan master, commit history pada branch akan digabungkan semuanya ke dalam commit history master. Visualisasinya adalah sebagai berikut.
	
	![Git Merge Diagram](https://devblogs.microsoft.com/devops/wp-content/uploads/sites/6/2016/03/regular-merge.png)

	Ketika menggunakan git merge --squash untuk menggabungkan branch tersebut dengan master, commit history pada branch tidak akan langsung digabungkan ke dalam commit history master, melainkan akan dibuat commit baru yang 'merangkum' seluruh commit yang pernah dibuat pada branch tersebut. Visualisasinya adalah sebagai berikut.
	
	![Git Merge Squash Diagram](https://devblogs.microsoft.com/devops/wp-content/uploads/sites/6/2016/03/squash-merge.png)

3. Apa **keunggulan menggunakan Version Control System** seperti Git dalam pengembangan suatu aplikasi?

	- Terdapat history yang memudahkan tracing program jika ditemui kendala setelah pembuatan fitur/versi baru pada aplikasi.
	- Pengerjaan suatu aplikasi/proyek dapat dilakukan dengan lebih efisien karena memungkinkan kolaborasi antardeveloper.
	- Memungkinkan pihak manajerial untuk melakukan live tracking terhadap pengerjaan suatu aplikasi/proyek.

### 2. Spring

4. Apa itu **library** & **dependency**?

	Library merupakan kumpulan/koleksi kode dengan fungsionalitas tertentu yang dapat dimanfaatkan untuk mengoptimalkan pembuatan suatu program. Koleksi kode tersebut terdiri dari fungsi-fungsi umum yang sering digunakan. Contoh library pada Java adalah OpenJDK dan Google Guava.

	Dependency merupakan konsep ketergantungan antarkode. Library, fungsi, atau potongan kode dapat dikatakan memiliki dependency ketika salah satu di antaranya digunakan untuk menyusun potongan kode, fungsi, atau library lain. Contoh, ketika library A digunakan untuk menyusun fungsi B, maka fungsi B dikatakan dependent terhadap library A.

5. Apa itu **Maven**? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?

	Maven merupakan suatu management tool yang digunakan untuk membuat dan mengelola proyek pemrograman. Maven memungkinkan developer untuk membuat proyek, dependency, dan dokumentasi dengan menggunakan Project Object Model (POM). Maven digunakan karena manfaat yang ditawarkannya, salah satunya adalah karena Maven memudahkan pembuatan serta meningkatkan efektivitas pembuatan proyek berbasis Java, yang digunakan dalam mata kuliah APAP. Selain Maven, terdapat juga ANT yang memiliki fungsionalitas yang sama dengan Maven, namun fitur yang disediakan tidak se-advanced Maven.

6. Selain untuk pengembangan web, **apa saja yang bisa dikembangkan dengan Spring** framework?

	Selain untuk pengembangan web apps, Spring juga dapat digunakan untuk membuat microservices, cloud, automated tasks (batch), dan yang lainnya.

7. Apa perbedaan dari **@RequestParam** dan **@PathVariable**? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?

	@RequestParam digunakan untuk mengekstrak data dari parameter query, sementara @PathVariable digunakan untuk mengekstrak data melalui URI. 

	Contoh penggunaan @RequestParam adalah sebagai berikut.
	> localhost:8080/is-palindrome?kalimat=((data))

	Sementara contoh penggunaan @PathVariable adalah sebagai berikut.
	> localhost:8080/is-palindrome/((data))

	@RequestParam biasanya digunakan pada website tradisional yang memanfaatkan transaksi data melalui proses querying. @RequestParam juga dapat dimanfaatkan ketika terdapat kemungkinan tidak ada data yang di-passing dengan menggantinya menjadi nilai default. @PathVariable lebih cocok digunakan untuk website yang memanfaatkan transaksi data melalui URI, contohnya adalah website RESTful.

### What I did not understand :confused:

 - [ ] Cara menghubungkan Controller, Model, dan View pada Spring
