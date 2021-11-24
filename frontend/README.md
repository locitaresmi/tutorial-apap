
# Tutorial APAP

## Authors

* **Wening Dyah Locitaresmi** - *1906299194* - *B*

## [Tutorial 7](https://scele.cs.ui.ac.id/pluginfile.php/128277/mod_resource/content/1/Tutorial%207%20Kelas%20A_B_C.pdf)

### Pertanyaan Tutorial

1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan

	a. Menghapus item dari cart

	Saya membuat fungsi baru pada component Home dengan nama handleRemoveItemFromCart yang memiliki parameter berupa objek yang akan dihapus. Fungsi ini dipanggil ketika icon trash pada cart ditekan. Fungsi ini memanfaatkan method .splice() untuk menghapus item dari list item pada cart. Selain menghapus item, fungsi ini juga mengubah boolean inCart yang awalnya true menjadi false. Saya juga menambahkan trigger onItemClick untuk fungsi tersebut pada elemen List. Berikut adalah screenshot dari fungsi handleRemoveItemFromCart. 

	Class-based:
	
	![Implementasi Menghapus Item dari Cart](https://i.ibb.co/7WsS4Y0/1637751050482.jpg)
	
	Functional-based:

	![Implementasi Menghapus Item dari Cart](https://i.ibb.co/Gn0dBjM/message-Image-1637746746748.jpg)

	b. Mengupdate balance

	Saya membuat fungsi baru bernama updateBalance untuk mengimplementasikan fitur ini. Fungsi ini dipanggil melalui fungsi updateShopItem, yang dipanggil setiap kali ada penambahan/pengurangan items dari cart. Fungsi updateBalance menerima dua parameter, yaitu itemPrice dan inCart. inCart digunakan untuk menentukan apakah objek akan dihapus/ditambah dari cart, yang mana jika dihapus, maka balance akan bertambah sebesar itemPrice dan sebaliknya. Berikut adalah screenshot implementasinya.
	
	Class-based:

	![Implementasi Mengupdate Balance](https://i.ibb.co/nrcXmB5/1637751294691.jpg)
	![Implementasi Mengupdate Balance](https://i.ibb.co/34wr91M/1637751070877.jpg)

	Functional-based:

	![Implementasi Mengupdate Balance](https://i.ibb.co/jWGzxPt/message-Image-1637746776393.jpg)

	c. Menambahkan alert ketika balance tidak cukup

	Saya tidak membuat fungsi baru untuk menerapkan fitur ini, melainkan saya menambahkan beberapa command pada fungsi yang sudah ada, yaitu handleAddItemToCart. Saya menambahkan 'validator' pada fungsi ini sebelum method penambahan item ke cart dijalankan. 'Validator' tersebut memeriksa kesesuaian balance dengan harga yang dimiliki item yang akan ditambahkan. Jika harga item lebih mahal dari balance yang dimiliki, maka sebuah alert akan diberikan dan fungsi akan dihentikan. Berikut adalah screenshot implementasinya.
	
	Class-based:

	![enter image description here](https://i.ibb.co/dPTCsD3/1637751092141.jpg)

	Functional-based:
	
	![Implementasi Alert](https://i.ibb.co/7g13f4d/1637746823612.jpg)
	
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara **state** dan **props**?

	Menurut pemahaman saya, salah satu perbedaan yang paling menonjol antara state dan props yaitu, state digunakan untuk me-render perbedaan yang terjadi pada komponen, yang sifatnya dinamis dan dapat berubah-ubah. Di lain sisi, props cenderung tidak dapat diubah. Selain itu, props digunakan untuk media komunikasi antarkomponen, sementara state cenderung digunakan untuk keperluan internal suatu komponen.

3. Menurut kamu, apakah sebaiknya kita menggunakan **component** (e.g. List, Item) dalam React? Sebutkan alasannya.

	Menurut saya, penggunaan component bergantung pada kompleksitas website yang akan dibuat. Jika website cenderung memiliki kompleksitas yang tinggi, maka sebaiknya component digunakan untuk meminimalisir redundansi kode (duplicate code). Namun, jika website memiliki kompleksitas yang sangat rendah, ada/tidaknya component tidak begitu berpengaruh karena kemungkinan terdapat redundansi kodenya sangat kecil.

4. Apa perbedaan **class component** dan **functional component**?

	Class component merupakan stateful component yang dalam penggunaannya, kita perlu melakukan extend dari React. Functional component merupakan stateless component yang dalam penggunaannya tidak memerlukan extend dari React karena functional component hanya berisi fungsi JavaScript. Selain itu, kita dapat mengimplementasikan React lifecycle pada class component, namun kita tidak dapat melakukannya di dalam functional component.

5. Dalam react, apakah **perbedaan component dan element**?

	Secara sederhana, elemen merupakan deskripsi dari suatu DOM yang tidak dapat diubah (immutable). Elemen menjelaskan apa yang ditampilkan pada layar. Component, di sisi lain, dapat diberikan beragam perlakuan, seperti pemberian fungsi. Component dapat terdiri dari beberapa elemen, namun tidak sebaliknya.

## [Tutorial 6](https://scele.cs.ui.ac.id/pluginfile.php/127578/mod_resource/content/3/Tutorial%206%20Kelas%20B.pdf)

### Pertanyaan Tutorial

1. Jelaskan secara singkat perbedaan **Otentikasi** dan **Otorisasi**! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?

	Otentikasi merupakan proses validasi identitas dari pengguna. Contoh penerapannya adalah sistem Pergipergi hanya akan menerima request jika pengguna sudah terotentikasi (sudah log in). Jika belum, pengguna akan diarahkan ke halaman log in. Otentikasi tersebut diimplementasi pada potongan kode berikut.

	`.anyRequest().authenticated()`
	
	Otorisasi merupakan proses validasi hak akses milik pengguna (dilakukan setelah proses otentikasi). Contoh penerapannya ketika hanya pengguna dengan role 'Admin' yang bisa mengakses halaman user/viewall. Salah satu implementasi dari otorisasi saya lakukan dalam kode berikut.

	 `.antMatchers("/user/viewall").hasAuthority("Admin")`

2. Apa itu **BCryptPasswordEncoder**? Jelaskan secara singkat cara kerja dan tujuannya.

	BCryptPasswordEncoder merupakan modul yang digunakan untuk melakukan proses encoding. Modul ini digunakan untuk menyimpan tulisan tertentu (biasanya password) menjadi kode lain yang telah di-enkripsi menggunakan algoritma BCrypt. Tujuannya adalah agar password tidak dapat dibaca secara harfiah (dengan tujuan keamanan data).

3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?

	Berdasarkan apa yang telah saya baca, password sebaiknya disimpan menggunakan hashing. Hal ini dikarenakan hashing sifatnya one-way (tidak dapat diterjemahkan kembali), sementara encryption sifatnya two-way, sehingga masih berisiko untuk di-decrypt (diterjemahkan) menjadi password yang sebenarnya.

4. Jelaskan secara singkat apa itu **UUID** beserta penggunaannya.

	UUID merupakan singkatan dari Universal Unique Identifier. UUID tujuannya sama seperti ID yang biasa diberikan kepada instance tertentu, yaitu untuk memberikan atribut pembeda antara satu instance dengan instance yang lainnya. Bedanya adalah UUID sifatnya universal, seperti namanya. Artinya, UUID dapat digunakan tidak terbatas pada suatu aplikasi saja, melainkan bisa digunakan dalam lingkup sistem yang lebih luas.

5. Apa kegunaan class **UserDetailsServiceImpl**.java? Mengapa harus ada class tersebut?

	UserDetailsServiceImpl merupakan suatu interface yang dapat digunakan untuk mengambil data pengguna. Class ini digunakan untuk mengimplementasi method loadUserByUsername, yang digunakan untuk mengambil informasi otentikasi serta otorisasi pengguna berdasarkan username-nya. Jika tidak digunakan, maka sistem tidak dapat melakukan proses otentikasi dan otorisasi.

## [Tutorial 5](https://scele.cs.ui.ac.id/pluginfile.php/126964/mod_resource/content/6/Tutorial%205%20Kelas%20B%20v1.3-2.pdf)

### Pertanyaan Tutorial

1. Apa itu **Postman**? Apa kegunaannya?

	Postman merupakan suatu tools yang dibuat untuk memudahkan developer dalam melakukan debugging serta testing pada API yang telah dibuatnya. Postman memudahkan kedua proses tersebut karena bentuknya berupa GUI (developer tidak harus melakukan debug/test pada CLI)

2. Jelaskan fungsi dari anotasi **@JsonIgnoreProperties** dan **@JsonProperty**.

	@JsonIgnoreProperties digunakan untuk mengabaikan fields tertentu pada level class. Hal ini digunakan ketika kita tidak ingin mengikutsertakan fields tersebut pada saat melakukan serialisasi JSON. @JsonProperty digunakan ketika kita ingin melakukan mapping nama suatu properti dengan salah satu key pada JSON saat melakukan serialisasi maupun deserialization.

3. Apa kegunaan atribut **WebClient**?

	Webclient digunakan ketika kita ingin mengirim atau mengambil data dari URI tertentu.

4. Apa itu **ResponseEntity** dan **BindingResult**? Apa kegunaannya?

	ResponseEntity merupakan representasi dari keseluruhan HTTP response, seperti status code, body, dan headers. Kita dapat menggunakannya ketika kita ingin melakukan kustomisasi terhadap HTTP response. BindingResult merupakan objek yang menyimpan hasil validasi serta kemungkinan error yang dapat muncul saat melakukan binding. Atribut ini harus digunakan ketika terjadi proses binding agar Spring dapat melakukan validasi selanjutnya.

## [Tutorial 3](https://scele.cs.ui.ac.id/pluginfile.php/122168/mod_resource/content/1/Tutorial%203%20Kelas%20B.pdf)

### Pertanyaan Tutorial
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model (@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
	
* @**AllArgsConstructor** digunakan untuk membuat constructor dengan parameter seluruh atribut dalam suatu class.
* @**NoArgsConstructor** digunakan untuk membuat constructor yang tidak memiliki parameter apapun.
* @**Setter** digunakan untuk menambahkan method setter di setiap atribut yang ada dalam suatu class.
* @**Getter** digunakan untuk menambahkan method getter di setiap atribut yang ada dalam suatu class.
* @**Entity** digunakan untuk memberikan tanda bahwa suatu class merupakan suatu 'entity' yang akan di-mapping ke dalam database.
* @**Table** digunakan untuk memberikan nama database yang akan digunakan untuk entity mapping.

	(Lombok)

2. Pada class TravelAgensiDb, terdapat method findByNoAgensi, apakah kegunaan dari method tersebut?

	Method findByNoAgensi digunakan untuk mencari objek Travel Agensi berdasarkan atribut noAgensi-nya.

3. Jelaskan perbedaan kegunaan dari anotasi @**JoinTable** dan @**JoinColumn**

	@JoinTable digunakan ketika kita ingin menyimpan id dari kedua entity di dalam table yang berbeda. Sementara @JoinColumn digunakan ketika kita ingin menyimpan id dari entity yang lain di column yang berbeda di dalam table yang sama. @JoinTable digunakan ketika kedua entity memiliki hubungan secara langsung (misalnya sebagai foreign key). Sementara @JoinColumn digunakan ketika hubungan antara kedua entity diatur di table yang lain.
	
	(JPA)

4. Pada class TourGuideModel, digunakan anotasi @JoinColumn pada atribut agensi, apa kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa perbedaan nullable dan penggunaan anotasi @NotNull

* **name**: berisi nama dari column (atribut) yang dipilih sebgai foreign key
* **referencedColumnName**: berisi nama dari column lain yang di-reference oleh column yang menjadi foreign key
* **nullable**: menentukan apakah column yang dipilih dapat berisi nilai null atau tidak

	Perbedaan antara nullable dan @NotNull adalah pelaku validasinya. Validasi @NotNull dilakukan oleh aplikasi Java, sementara validasi nullable dilakukan oleh database. Ketika menggunakan @NotNull, apabila validasi pada aplikasi ternyata gagal, maka tidak ada perintah SQL apapun yang akan dieksekusi. Sebaliknya, ketika menggunakan nullable, perintah SQL akan dieksekusi karena pengecekan dilakukan pada database.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER

* **FetchType. LAZY** digunakan untuk mengembalikan data dari database sesuai data yang diminta
* **FetchType.EAGER** digunakan untuk mengembalikan seluruh data dari database (termasuk data yang tidak diminta)
* **CascadeType.ALL** digunakan untuk 'menyebarkan' seluruh operasi yang dimiliki parent entity kepada child entity-nya

## [Tutorial 2](https://scele.cs.ui.ac.id/pluginfile.php/121316/mod_resource/content/1/Tutorial%202%20Kelas%20B.pdf)

### Pertanyaan Tutorial

1. Cobalah untuk menambahkan sebuah Agensi dengan mengakses link
berikut: http://localhost:8080/agensi/add?idAgensi=1&namaAgensi=Papa%20APAP&alamat=Maung%20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi

	Saat menjalankan link tersebut, halaman yang muncul adalah Whitelabel Error Page dengan error message-nya, yaitu, "Required URI template variable 'idAgensi' for method parameter type String is not present". Hal ini disebabkan karena belum adanya template yang dapat merender variabel idAgensi. IdAgensi tersebut berasal dari kode di bawah ini.
	>model.addAttribute("idAgensi", idAgensi);
	
2. Menurut kamu anotasi **@Autowired** pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat.

	Anotasi @Autowired merupakan implementasi dari konsep Dependency Injection (DI). @Autowired digunakan pada TravelAgensiController untuk meminta aplikasi (PergipergiApplication) untuk melakukan injection dari instance TravelAgensiService pada controller tersebut. Hal ini dimaksudkan agar controller dapat mengakses method yang telah diimplementasikan oleh TravelAgensiServiceImpl. 

3. Cobalah untuk menambahkan sebuah Agensi dengan mengakses link  
berikut: http://localhost:8080/agensi/add?idAgensi=1&namaAgensi=Papa%20APAP&alamat=Maung%20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.

	Ketika link tersebut diakses, halaman yang akan muncul adalah Whitelabel Error Page dengan error message-nya, yaitu, "Required request parameter 'noTelepon' for method parameter type String is not present". Error tersebut terjadi karena atribut noTelepon merupakan atribut yang wajib diisi ketika melakukan proses add data. Parameter yang membuatnya wajib diisi terdapat pada kode berikut.
	>@RequestParam(value = "noTelepon", required = true) String noTelepon,

4. Jika Papa APAP ingin melihat Travel Agensi dengan nama Papa APAP, link apa yang harus diakses?

	Jika Papa ingin melihat Travel Agensi dengan nama tersebut, Papa dapat mengakses link http://localhost:8080/agensi/view?idAgensi=1 atau http://localhost:8080/agensi/view/id-agensi/1 (yang saat ini berfungsi pada program karena telah diubah menggunakan @GetMapping). Papa harus mengaksesnya menggunakan id dari agensi karena parameter yang diterima oleh metode view pada program hanya id agensi saja.

5. Tambahkan 1 contoh Travel Agensi lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/agensi/viewAll, apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.

	Setelah mengakses link tersebut, halaman yang ditampilkan adalah daftar dari seluruh travel agensi yang telah terdaftar (di-add) sebelumnya. Berikut adalah screenshotnya.
	
	![Screenshot No. 5](https://i.ibb.co/P4HyV3Y/Soal-Nomor-5.jpg)

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