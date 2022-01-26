# DSwab
Progress Dswab (done)
version 1.0


Alur proses bisnis

user mendaftarkan dir menggunakan email -> mengisi data personal yang mau di swab -> melakukan pembayaran -> hasil tes dikirim melalui email beserta informasi pembayaran->user dapat melihat peta lokasi rumah sakit pada halaman utama

Alur front end 

Splash view -> onboarding -> Home : -> reservasi  (Intent) -> registration view (Activity) -> detail reservation(Activity) -> payment (Activity)
                                    -> symtomps view (fragment)
                                    -> cuci tangan view (fragment)
                                    -> help or about view (fragment) 
                                    -> history (change to be map) view (Intent) -> activity hospitalloc yang akan menampilkan lokasi dari rumah sakit yang dapat dipesan karena                                        telah bekerjasama dengan aplikasi
                                    
Alur back end   
menggunakan  API firebase dengan basis no sql 
