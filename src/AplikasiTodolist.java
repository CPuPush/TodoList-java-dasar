public class AplikasiTodolist {

    // Model
    public static String[] model = new String[10];


    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    // Main
    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
//        testRemove();
//        testInput();
//        testViewShowTodoList();\
//        testViewAddTodoList();
//        testViewRemoveTodoList();

        //akhir aplikasi
        viewShowTodoList();
    }



    // Business Logic
    public static void showTodoList(){
        for(var i = 0; i< model.length;i++){
            var todo = model[i];
            var no = i + 1;

            if(todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    // method untuk test showTodoList
    public static void testShowTodoList(){
        model[0] = "test 1";
        model[1] = "test 2";
        showTodoList();
    }

    public static void addTodoList(String todo){
        // cek penuh atau belum
        boolean isFull = true;
        for (int i = 0; i < model.length;i++){
            if(model[i] == null){
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }
        // jika penuh, maka ukuran di resize 2x
        if(isFull){
            var temp = model;
            //jika hanya seperti ini code dibawah maka data lama akan hilang sehingga dibutuhkan temporary file untuk menyimpan data
            model = new String[model.length * 2];

            // memasukkan data temporary ke model lagi
            for(int i = 0; i< temp.length; i++){
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi yang data arraynya null
        for(var i = 0;i < model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

//    test menambah TodoList
    public static void testAddTodoList(){
//        addTodoList("satu");
//        addTodoList("dua");
//        addTodoList("tiga");
//        addTodoList("empat");
//        addTodoList("lima");
//        addTodoList("enam");
//        addTodoList("tujuh");
//        addTodoList("delapan");
//        addTodoList("sembilan");
//        addTodoList("sepuluh");
//        addTodoList("sebelas");
        for (int i = 0; i<25;i++){
            addTodoList("Contoh todo ke. " + i);
        }
        showTodoList();
    }

    public static boolean removeTodoList(Integer number){
        if((number - 1) >= model.length){
            return false;
        } else if (model[number-1] == null){
            return false;
        }else{
            for(int i = (number - 1); i < model.length; i++){
                if (i == (model.length - 1)){
                    model[i] = null;
//                    System.out.println(i);
                }else {
                    model[i] = model[i+1];
                }
            }
                return  true;
        }
    }
//    test menghapus todolist
    public static void testRemove(){
        for (int i = 0; i<6;i++){
            addTodoList("Contoh todo ke. " + (i + 1));
        }
        showTodoList();
        System.out.println(removeTodoList(6));
        showTodoList();
    }

//    menerima input data
    public static String input(String info){
        System.out.print(info + " : ");
//        menerima input data dari user
        String data = scanner.nextLine();
        return  data;
    }

    public static void testInput(){
        String name = input("Nama");
        System.out.println("Hi " + name);

        String program = input("Channelnya apa?");
        System.out.println("Subscribe dong channelnya " + program);
    }

    // View
    public static void viewShowTodoList(){
        while (true){
            System.out.println("TodoList");
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            String input = input("Pilih");
            if(input.equals("1")){
                viewAddTodoList();
            }else if(input.equals("2")){
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else{
                System.out.println("Pilihan tidak ada!");
            }
            // todo .equals digunakan untuk membandingan untuk string, jika untuk number menggunakan ==, maka untuk string menggunakan .equals();
        }
    }
    // Test viewShowTodoList
    public static void testViewShowTodoList(){
        addTodoList("aku");
        addTodoList("kamu");
        addTodoList("Dia");
        addTodoList("Cinta");

        viewShowTodoList();
    }

    public static void viewAddTodoList(){
        System.out.println("Menambah TodoList");
        String todo = input("Todo (x jika batal)");

        if(todo.equals("x")){
            // batal
            viewShowTodoList();
        }else {
            addTodoList(todo);
        }
    }
    //test viewAddTodoList
    public static void testViewAddTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewAddTodoList();

        showTodoList();
    }

    public static void viewRemoveTodoList(){
        System.out.println("Menghapus TodoList");

        String todo = input("Nomor yang dihapus (x jika batal)");
        if(todo.equals("x")){
            //batal
        }else{
            //todo yang dihasilkan adalah string, jadi kita harus melakukan konversi terlebih dahulu
            boolean success = removeTodoList(Integer.valueOf(todo));
            if(!success){
                System.out.println("Gagal Menghapus Todo ke : " + todo);
            }
        }
    }

    //test viewRemoveTodoList
    public static void testViewRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
