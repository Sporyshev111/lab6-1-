package com.company;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {
   static File file = new File("Lab.dat");

    public static ArrayList<Long> arroffuserstay = new ArrayList<>();


    public static void MaxUserStay() {
        System.out.println("Максимальное время простоя пользователя: " + Collections.max(arroffuserstay) + " c");
    }

    public static boolean Islogbigger50() {
        boolean bigger = false;
        if (logs.size() == 50) {
            bigger = true;
        }
        return bigger;
    }

    public static void UserStay() {
        if (dates.size() >= 2) {
            long start = dates.get(dates.size() - 2).getTime();
            long end = dates.get(dates.size() - 1).getTime();
        }


        long start = dates.get(dates.size() - 1).getTime();
        long end = System.currentTimeMillis();

        long diff = end - start;
        long difference = diff / 1000;

        arroffuserstay.add(difference);

    }

    public static ArrayList<Date> dates = new ArrayList<>();
    public static ArrayList<String[]> logs = new ArrayList<>();

    public static void Updateoperation(String[] name) {
        Operations operation = Operations.UPDATE;

        Log addinglog = new Log(new Date(), operation.name(), name);
        String str;
        dates.add(addinglog.datatime);
        if (Islogbigger50()) {
            logs.remove(0);
            logs.add(new String[]{addinglog.datatime.toString(), addinglog.operation, str = String.join(" ", name)});
        } else {
            logs.add(new String[]{addinglog.datatime.toString(), addinglog.operation, str = String.join(" ", name)});
        }
        dates.add(addinglog.datatime);

    }

    public static void Deleteoperation(String[] name) {
        Operations operation = Operations.DELETE;

        Log addinglog = new Log(new Date(), operation.name(), name);
        String str;
        if (Islogbigger50()) {
            logs.remove(0);
            logs.add(new String[]{addinglog.datatime.toString(), addinglog.operation, str = String.join(" ", name)});
        } else {
            logs.add(new String[]{addinglog.datatime.toString(), addinglog.operation, str = String.join(" ", name)});
        }
        dates.add(addinglog.datatime);

    }

    public static void ADDoperation(String[] name) {
        Operations operation = Operations.ADD;

        Log addinglog = new Log(new Date(), operation.name(), name);
        String str;
        if (Islogbigger50()) {
            logs.remove(0);
            logs.add(new String[]{addinglog.datatime.toString(), addinglog.operation, str = String.join(" ", name)});
        } else {
            logs.add(new String[]{addinglog.datatime.toString(), addinglog.operation, str = String.join(" ", name)});
        }
        dates.add(addinglog.datatime);


    }


    public static void ShowLine(String[] line) {
        for (String field : line
        ) {
            System.out.print(field + "\t");

        }
        System.out.println();
    }


    //    public static String [] replacingstring;
    public static void Findfild(ArrayList<String[]> values, String fildtofind) {
        for (String[] line : values
        ) {
            for (String fild : line
            ) {

                if (fild.toLowerCase(Locale.ROOT).trim().contains(fildtofind.toLowerCase(Locale.ROOT).trim())) {
                    ShowLine(line);
                    break;
                }
            }
        }
    }

    public static int indextoreplace;

    public static void ReplaceLine(String[] replacingstring, int indextoreplace) {

        Updateoperation(values.get(indextoreplace));
        values.set(indextoreplace, replacingstring);
    }

    public static int indextodelete;
    public static int n;
    public static boolean progison = true;

    public static void RemoveLine(ArrayList<String[]> values, int indextodelete) {
        Deleteoperation(values.get(indextodelete));
        values.remove(indextodelete);

    }

    //    public static ArrayList <String> notes = new ArrayList<>();
    public static ArrayList<String[]> values = new ArrayList<>();


    public enum Stroy {
        F, UG, NO
    }


    public static class Geography {


        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();
        String capital = scanner.nextLine();

        int popularity = Integer.parseInt(scanner.nextLine());
        String stroy = scanner.nextLine();


        public Geography(String gosudarstvo, String stoliza, int naselenie, String stroy) {

            this.country = gosudarstvo;
            this.capital = stoliza;
            this.popularity = naselenie;
            this.stroy = stroy;
        }

        public Geography() {

        }


    }

    public static void main(String[] args) {
        String readlog = null;
        try(BufferedReader br = new BufferedReader (new FileReader("Lab.dat")))
        {
            // чтение посимвольно
            int c;

            if(( c= br.read())!=-1) {

                readlog="";
                readlog+= (char) c;
                while ((c = br.read()) != -1) {

                    readlog += (char) c;
                }
            }

        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        while (progison) {
            Scanner scanner = new Scanner(System.in);


            System.out.println("1 - Просмотр таблицы");
            System.out.println("2 - Добавить запись");
            System.out.println("3 - Удалить запись");
            System.out.println("4 - Обновить запись");
            System.out.println("5 - Поиск записи");
            System.out.println("6 - Просмотреть лог");
            System.out.println("7 - Выход");
            System.out.println();
            System.out.println("Введите операцию для выполнения: ");

            int numofoperation = Integer.parseInt(scanner.nextLine());
            switch (numofoperation) {
                case 1: {
                    JFrame frame = new JFrame("FRAME");
                    frame.setSize(new Dimension(600, 400));
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    frame.setLayout(new GridBagLayout());
//            JButton addButton = new JButton("Добавить");
//            JButton deleteButton = new JButton("Удалить");
//            JButton clearButton = new JButton("Очистить");
                    CountryTableModel btm = new CountryTableModel();
                    JTable countryTable = new JTable(btm);
                    JScrollPane countryTableScrollPage = new JScrollPane(countryTable);
                    countryTableScrollPage.setPreferredSize(new Dimension(400, 400));

                    for (int i = 0; i < values.size(); i++) {

                        btm.addDate(values.get(i));
                    }
                    frame.add(countryTableScrollPage, new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
//            frame.add(addButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
//            frame.add(deleteButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));
//            frame.add(clearButton, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(1, 1, 1, 1), 0, 0));

                    frame.setVisible(true);
                    frame.pack();

                    break;
                }
                case 2: {

                    System.out.println("Введите количество географических объектов для добавления: ");

                    n = Integer.parseInt(scanner.nextLine());

                    Geography[] countries = new Geography[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Введите данные страны: 1)Гос, 2)Стол, 3)Нас, 4)Строй");
                        Geography g1 = new Geography();
                        countries[i] = g1;
                    }
                    for (int i = 0; i < countries.length; i++) {
                        switch (countries[i].stroy) {
                            case "F": {
                                Stroy stroy = Stroy.F;


                                break;
                            }

                            case "UG": {
                                Stroy stroy1 = Stroy.UG;


                                break;
                            }
                            default: {
                                Stroy stroy2 = Stroy.NO;
                                break;
                            }


                        }
                    }
                    for (int i = 0; i < n; i++) {
                        values.add(new String[]{countries[i].country, countries[i].capital, Integer.toString(countries[i].popularity), countries[i].stroy});
                        ADDoperation(new String[]{countries[i].country, countries[i].capital, Integer.toString(countries[i].popularity), countries[i].stroy});
                    }
                    File();

                    break;
                }
                case 3: {
                    System.out.println("Введите индекс строки для удаления: ");
                    indextodelete = Integer.parseInt(scanner.nextLine());
                    indextodelete--;
                    RemoveLine(values, indextodelete);
                    File();
                    break;
                }
                case 4: {
                    System.out.println("Введите индекс строки для замены: ");
                    indextoreplace = Integer.parseInt(scanner.nextLine());
                    indextoreplace--;
                    System.out.println("Введите данные страны: 1)Гос, 2)Стол, 3)Нас, 4)Строй");
                    Geography countrie = new Geography();
                    String[] replacingstring = {countrie.country, countrie.capital, Integer.toString(countrie.popularity), countrie.stroy};
                    ReplaceLine(replacingstring, indextoreplace);
                    File();
                    break;

                }
                case 5: {
                    String findtoword;
                    System.out.println("1 - Найти слово");
                    System.out.println("2 - Население больше чем");
                    System.out.println("3 - Население меньше чем");
                    System.out.println("Выберите фильтр: ");

                    int choosefilter = Integer.parseInt(scanner.nextLine());
                    switch (choosefilter) {
                        case 1: {
                            System.out.println("Введите слово для поиска: ");
                            findtoword = scanner.nextLine();
                            Findfild(values, findtoword);

                            break;
                        }
                        case 2: {
                            System.out.println("Найти население больше чем: ");
                            int populationbigger = Integer.parseInt(scanner.nextLine());
                            for (String[] line : values
                            ) {
                                for (String fild : line
                                ) {

                                    if (fild.matches("\\d+") && Integer.parseInt(fild) > populationbigger) {

                                        ShowLine(line);
                                    }
                                }
                            }

                            break;
                        }
                        case 3: {

                            System.out.println("Найти население меньше чем: ");
                            int populationbigger = Integer.parseInt(scanner.nextLine());
                            for (String[] line : values
                            ) {
                                for (String fild : line
                                ) {

                                    if (fild.matches("\\d+") && Integer.parseInt(fild) < populationbigger) {

                                        ShowLine(line);
                                    }
                                }
                            }

                            break;
                        }
                    }

                    break;
                }
                case 6: {
                    if(readlog!=null)
                    {
                        System.out.println(readlog);
                        if (logs.size() >= 1) {

                            for (String[] obj : logs
                            ) {
                                for (String equals : obj
                                ) {
                                    System.out.print(equals + " ");

                                }
                                System.out.println();
                            }
                            UserStay();
                            MaxUserStay();
                        }
                    }
                    else if(logs.size() >= 1){
                        for (String[] obj : logs
                        ) {
                            for (String equals : obj
                            ) {
                                System.out.print(equals + " ");

                            }
                            System.out.println();
                        }
                    UserStay();
                    MaxUserStay();
                }
                    else System.out.println("Логов нет");
                    break;
                }
                case 7: {
                    progison = false;
                    System.exit(0);
                    break;
                }

            }

        }

    }
    public static void File() {
        try( FileOutputStream fileoutput=new FileOutputStream(file, true)){
            if (!file.exists())
                file.createNewFile();

if(logs.size()>=1) {
    for (String[] strlog : logs
    ) {
        for (String equals : strlog
        ) {
            byte[] buffer = equals.getBytes();
            fileoutput.write(buffer, 0, buffer.length);


        }



    }
}


        }catch (IOException e)
        {
            System.out.println("Error: "+ e);
        }

    }
}



