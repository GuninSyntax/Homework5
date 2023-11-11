package additional_task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book {
    private int id;
    private String title;
    private String genre;
    private String author;
    private String description;
    private int yearOfRelease;

    static private int countBooks = 0;
    static private List<Book> allBooks = new ArrayList<>();
    static private List<Book> tempBooks = new ArrayList<>();
    static private List<Book> tempBooksAuthor = new ArrayList<>();
    static private List<Book> tempBooksGenre = new ArrayList<>();
    static private List<Book> tempBooksRelease = new ArrayList<>();
    static private final String errorNoChoicePage = "Такого варианта выбора нет, повторите попытку...";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Book(String title, String genre, String author, String description, int yearOfRelease) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.description = description;
        this.yearOfRelease = yearOfRelease;
        this.id = countBooks;
    }

    private static void initFirstBook() {
        countBooks++;
        Book book1 = new Book("Оно", "Ужасы", "Стивен Кинг",
                "Загадочная история о инопланетном монстре, который кошмарит небольшой город " +
                        "пожирая детей...", 1986);
        allBooks.add(book1);
        countBooks++;
        Book book2 = new Book("Гарри Поттер", "Фентези", "Джоан Роулинг",
                "Волшебная история о мальчике живущем под лестницей (Не то, что бы ему нравилось)" +
                        ", жизнь которого изменилась в 10 лет...",
                1997);
        allBooks.add(book2);
        countBooks++;
        Book book3 = new Book("До встречи с тобой", "Драма", "Джоджо Мойес",
                "История любви на коляске...",
                2012);
        allBooks.add(book3);
        countBooks++;
        Book book4 = new Book("Властелин колец", "Фентези", "Джон Рональд Руэл Толкин",
                "История о \"человеке\", который бы никогда не стал баскетболистом, в итоге и не стал...",
                1955);
        allBooks.add(book4);
        countBooks++;
        Book book5 = new Book("Голодные игры", "Роман", "Сьюзен Коллинз",
                "Либо ты, либо тебя, хорошо если попадешься с парнем, который буллил тебя в 5 классе...",
                2008);
        allBooks.add(book5);
        countBooks++;
        Book book6 = new Book("Чарли и Шоколадная фабрика", "Фентези", "Роальд Даль",
                "История о мальчике, у который полный рот коренных зубов, с которыми придется попрощаться",
                1964);
        allBooks.add(book6);
        countBooks++;
        Book book7 = new Book("Сумерки", "Роман", "Стефани Майер",
                "Вампиры верят, что самые праведные из них после смерти попадают на станцию переливания крови",
                2005);
        allBooks.add(book7);
        countBooks++;
        Book book8 = new Book("Зеленая миля", "Роман", "Стивен Кинг",
                "Даже писать нечего...реально грустно", 1996);
        allBooks.add(book8);
        countBooks++;
        Book book9 = new Book("Побег из Шоушенка", "Криминал/драма", "Стивен Кинг",
                "История про последствие \"Cвободы слова\"", 1982);
        allBooks.add(book9);
        countBooks++;
        Book book10 = new Book("Бойцовский клуб", "Криминал/драма", "Чак Паланик",
                "Первое правило бойцовского клуба...", 1996);
        allBooks.add(book10);
    }

    public static void initBookLibrary() {
        initFirstBook();
        printWelcome();
        while (true) {
            printHomePage();
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInt = Integer.parseInt(inputUser);
                switch (inputUserInt) {
                    case 1:
                        allBookPage();
                        break;
                    case 2:
                        searchBookPage();
                        break;
                    case 3:
                        addABookPage();
                        break;
                    case 4:
                        removeBookPage();
                        break;
                    default:
                        System.out.println(errorNoChoicePage);
                }
            }
        }
    }

    private static void printWelcome() {
        System.out.println("***************************************************************");
        System.out.println("***************************************************************");
        System.out.println("***************************************************************\n");
        System.out.println("\t\t ДОБРО ПОЖАЛОВАТЬ В КНИГОТЕКУ ГУНИНА Д. А.");
        System.out.println("\n***************************************************************");
        System.out.println("***************************************************************");
        System.out.println("***************************************************************\n");
    }

    private static void printHomePage() {
        System.out.println("________________________________________________________________________________________");
        System.out.println("Пожалуйста выберите страницу из предложенных: ");
        System.out.println();
        System.out.println("1. Показать всю коллекцию книг");
        System.out.println("2. Поиск книги");
        System.out.println("3. Добавить книгу");
        System.out.println("4. Удалить книгу");
    }

    private static String getInputUser() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (true) {
            System.out.println();
            System.out.print("Пожалуйста, введите номер варианта (или введите \"Выйти\" для выхода): ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("Выйти")) break;
            else if (input.isEmpty()) {
                System.out.println("Нельзя вводить пустою строку");
                continue;
            } else if (checkInputNumber(input)) break;
            else System.out.println(errorNoChoicePage);
        }
        return input;
    }

    private static boolean checkInputNumber(String input) {
        boolean haveNumber = true;
        char[] array = input.toCharArray();
        for (Character c : array) {
            if (!Character.isDigit(c)) {
                haveNumber = false;
                break;
            }
        }
        return haveNumber;
    }

    private static void allBookPage() {
        while (true) {
            System.out.println("________________________________________________________________________________________");
            System.out.println("ВЫБОР КНИГИ ИЗ ВСЕЙ КОЛЛЕКЦИИ");
            System.out.println();
            for (int i = 0; i < allBooks.size(); i++) {
                System.out.println(1 + i + ". \"" + allBooks.get(i).getTitle() + "\" " + allBooks.get(i).getAuthor());
            }
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInt = Integer.parseInt(inputUser);
                if (inputUserInt < 1 || inputUserInt > allBooks.size()) System.out.println(errorNoChoicePage);
                else {
                    selectedBookOfAllBooks(inputUserInt);
                }
                break;
            }
        }
    }

    private static void selectedBookOfAllBooks(int inputUser) {
        System.out.println("________________________________________________________________________________________");
        for (int i = 0; i < allBooks.size(); i++) {
            if (inputUser == i + 1) {
                System.out.println("ID КНИГИ: " + allBooks.get(i).getId());
                System.out.println("НАЗВАНИЕ КНИГИ: " + allBooks.get(i).getTitle());
                System.out.println("АВТОР: " + allBooks.get(i).getAuthor());
                System.out.println("ЖАНР: " + allBooks.get(i).getGenre());
                System.out.println("ГОД ИЗДАНИЯ: " + allBooks.get(i).getYearOfRelease());
                System.out.println("КРАТКОЕ ОПИСАНИЕ: " + allBooks.get(i).getDescription());
            }
        }
    }

    private static void searchBookPage() {
        while (true) {
            System.out.println("________________________________________________________________________________________");
            System.out.println("ВЫБОР ВАРИАНТА ПОИСКА");
            System.out.println();
            System.out.println("1. Поиск книги по названию");
            System.out.println("2. Поиск книги по автору");
            System.out.println("3. Поиск книги по жанру");
            System.out.println("4. Поиск книги по году издания");
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInt = Integer.parseInt(inputUser);
                switch (inputUserInt) {
                    case 1:
                        searchBookByTitle();
                        break;
                    case 2:
                        searchBookByAuthor();
                        break;
                    case 3:
                        searchBookByGenre();
                        break;
                    case 4:
                        searchBookByRelease();
                        break;
                    default:
                        System.out.println(errorNoChoicePage);
                }
                break;
            }
        }
    }

    private static void searchBookByTitle() {
        while (true) {
            System.out.println("________________________________________________________________________________________");
            System.out.println("ПОИСК ПО НАЗВАНИЮ");
            for (int i = 0; i < allBooks.size(); i++) {
                System.out.println(1 + i + ". \"" + allBooks.get(i).getTitle() + "\"");
            }
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInt = Integer.parseInt(inputUser);
                if (inputUserInt < 1 || inputUserInt > allBooks.size()) System.out.println(errorNoChoicePage);
                else {
                    selectedBookOfAllBooks(inputUserInt);
                }
                break;
            }
        }
    }

    private static void searchBookByAuthor() {
        while (true) {
            System.out.println("________________________________________________________________________________________");
            System.out.println("ПОИСК ПО АВТОРУ");
            for (int i = 0; i < allBooks.size(); i++) {
                if (!tempBooks.contains(allBooks.get(i).getAuthor())) {
                    tempBooks.add(allBooks.get(i));
                }
            }
            for (int i = 0; i < tempBooks.size(); i++) {
                for (int j = 0; j < tempBooks.size(); j++) {
                    if (tempBooks.get(i).getAuthor().equalsIgnoreCase(tempBooks.get(j).getAuthor()) &&
                            tempBooks.get(i) != tempBooks.get(j)) {
                        tempBooks.remove(j);
                    }
                }
            }
            for (int i = 0; i < tempBooks.size(); i++) {
                System.out.println(1 + i + ". \"" + tempBooks.get(i).getAuthor() + "\"");
            }
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInt = Integer.parseInt(inputUser);
                if (inputUserInt < 1 || inputUserInt > tempBooks.size()) System.out.println(errorNoChoicePage);
                else {
                    selectedAuthorBooks(inputUserInt);
                }
                break;
            }
        }
        tempBooks.clear();
    }

    private static void selectedAuthorBooks(int input) {
        System.out.println("________________________________________________________________________________________");
        while (true) {
            for (int i = 0; i < tempBooks.size(); i++) {
                if (input == 1 + i) {
                    for (int j = 0; j < allBooks.size(); j++) {
                        if (tempBooks.get(i).getAuthor().equalsIgnoreCase(allBooks.get(j).getAuthor())) {
                            tempBooksAuthor.add(allBooks.get(j));
                        }
                    }
                }
            }
            for (int i = 0; i < tempBooksAuthor.size(); i++) {
                System.out.println(1 + i + ". \"" + tempBooksAuthor.get(i).getTitle() + "\"");
            }
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInteger = Integer.parseInt(inputUser);
                selectedBookOfAuthor(inputUserInteger);
                tempBooksAuthor.clear();
                tempBooks.clear();
                break;
            }
        }
        tempBooksAuthor.clear();
        tempBooks.clear();
    }

    private static void selectedBookOfAuthor(int inputUser) {
        System.out.println("________________________________________________________________________________________");
        for (int i = 0; i < tempBooksAuthor.size(); i++) {
            if (inputUser == i + 1) {
                System.out.println("ID КНИГИ: " + tempBooksAuthor.get(i).getId());
                System.out.println("НАЗВАНИЕ КНИГИ: " + tempBooksAuthor.get(i).getTitle());
                System.out.println("АВТОР: " + tempBooksAuthor.get(i).getAuthor());
                System.out.println("ЖАНР: " + tempBooksAuthor.get(i).getGenre());
                System.out.println("ГОД ИЗДАНИЯ: " + tempBooksAuthor.get(i).getYearOfRelease());
                System.out.println("КРАТКОЕ ОПИСАНИЕ: " + tempBooksAuthor.get(i).getDescription());
            }
        }
    }

    private static void searchBookByGenre() {
        System.out.println("________________________________________________________________________________________");
        System.out.println("ПОИСК ПО ЖАНРУ");
        while (true) {
            for (int i = 0; i < allBooks.size(); i++) {
                if (!tempBooks.contains(allBooks.get(i).getGenre())) {
                    tempBooks.add(allBooks.get(i));
                }
            }
            for (int i = 0; i < tempBooks.size(); i++) {
                for (int j = 0; j < tempBooks.size(); j++) {
                    if (tempBooks.get(i).getGenre().equalsIgnoreCase(tempBooks.get(j).getGenre()) &&
                            tempBooks.get(i) != tempBooks.get(j)) {
                        tempBooks.remove(j);
                    }
                }
            }
            for (int i = 0; i < tempBooks.size(); i++) {
                System.out.println(1 + i + ". \"" + tempBooks.get(i).getGenre() + "\"");
            }
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInt = Integer.parseInt(inputUser);
                if (inputUserInt < 1 || inputUserInt > tempBooks.size()) System.out.println(errorNoChoicePage);
                else {
                    selectedGenreBooks(inputUserInt);
                }
                break;
            }
        }
        tempBooks.clear();
    }

    private static void selectedGenreBooks(int input) {
        System.out.println("________________________________________________________________________________________");
        while (true) {
            for (int i = 0; i < tempBooks.size(); i++) {
                if (input == 1 + i) {
                    for (int j = 0; j < allBooks.size(); j++) {
                        if (tempBooks.get(i).getGenre().equalsIgnoreCase(allBooks.get(j).getGenre())) {
                            tempBooksGenre.add(allBooks.get(j));
                        }
                    }
                }
            }
            for (int i = 0; i < tempBooksGenre.size(); i++) {
                System.out.println(1 + i + ". \"" + tempBooksGenre.get(i).getTitle() + "\" " +
                        tempBooksGenre.get(i).getAuthor());
            }
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInteger = Integer.parseInt(inputUser);
                selectedBookOfGenre(inputUserInteger);
                tempBooksGenre.clear();
                tempBooks.clear();
                break;
            }
        }
        tempBooks.clear();
        tempBooksGenre.clear();
    }

    private static void selectedBookOfGenre(int inputUser) {
        System.out.println("________________________________________________________________________________________");
        for (int i = 0; i < tempBooksGenre.size(); i++) {
            if (inputUser == i + 1) {
                System.out.println("ID КНИГИ: " + tempBooksGenre.get(i).getId());
                System.out.println("НАЗВАНИЕ КНИГИ: " + tempBooksGenre.get(i).getTitle());
                System.out.println("АВТОР: " + tempBooksGenre.get(i).getAuthor());
                System.out.println("ЖАНР: " + tempBooksGenre.get(i).getGenre());
                System.out.println("ГОД ИЗДАНИЯ: " + tempBooksGenre.get(i).getYearOfRelease());
                System.out.println("КРАТКОЕ ОПИСАНИЕ: " + tempBooksGenre.get(i).getDescription());
            }
        }
    }

    private static void searchBookByRelease() {
        System.out.println("________________________________________________________________________________________");
        System.out.println("ПОИСК ПО ГОДУ РЕЛИЗА");
        while (true) {
            for (int i = 0; i < allBooks.size(); i++) {
                if (!tempBooks.contains(allBooks.get(i).getYearOfRelease())) {
                    tempBooks.add(allBooks.get(i));
                }
            }
            for (int i = 0; i < tempBooks.size(); i++) {
                for (int j = 0; j < tempBooks.size(); j++) {
                    if (tempBooks.get(i).getYearOfRelease() == tempBooks.get(j).getYearOfRelease() &&
                            tempBooks.get(i) != tempBooks.get(j)) {
                        tempBooks.remove(j);
                    }
                }
            }
            for (int i = 0; i < tempBooks.size(); i++) {
                System.out.println(1 + i + ". " + tempBooks.get(i).getYearOfRelease() + " год.");
            }
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInt = Integer.parseInt(inputUser);
                if (inputUserInt < 1 || inputUserInt > tempBooks.size()) System.out.println(errorNoChoicePage);
                else {
                    selectedRelease(inputUserInt);
                }
                break;
            }
        }
        tempBooks.clear();
    }

    private static void selectedRelease(int input) {
        System.out.println("________________________________________________________________________________________");
        while (true) {
            for (int i = 0; i < tempBooks.size(); i++) {
                if (input == 1 + i) {
                    for (int j = 0; j < allBooks.size(); j++) {
                        if (tempBooks.get(i).getYearOfRelease() == (allBooks.get(j).getYearOfRelease())) {
                            tempBooksRelease.add(allBooks.get(j));
                        }
                    }
                }
            }
            for (int i = 0; i < tempBooksRelease.size(); i++) {
                System.out.println(1 + i + ". \"" + tempBooksRelease.get(i).getTitle() + "\" " +
                        tempBooksRelease.get(i).getAuthor());
            }
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInteger = Integer.parseInt(inputUser);
                selectedBookRelease(inputUserInteger);
                tempBooksRelease.clear();
                tempBooks.clear();
                break;
            }
        }
        tempBooks.clear();
        tempBooksRelease.clear();
    }

    private static void selectedBookRelease(int inputUser) {
        System.out.println("________________________________________________________________________________________");
        for (int i = 0; i < tempBooksRelease.size(); i++) {
            if (inputUser == i + 1) {
                System.out.println("ID КНИГИ: " + tempBooksRelease.get(i).getId());
                System.out.println("НАЗВАНИЕ КНИГИ: " + tempBooksRelease.get(i).getTitle());
                System.out.println("АВТОР: " + tempBooksRelease.get(i).getAuthor());
                System.out.println("ЖАНР: " + tempBooksRelease.get(i).getGenre());
                System.out.println("ГОД ИЗДАНИЯ: " + tempBooksRelease.get(i).getYearOfRelease());
                System.out.println("КРАТКОЕ ОПИСАНИЕ: " + tempBooksRelease.get(i).getDescription());
            }
        }
    }

    private static void addABookPage() {
        String title = null;
        String genre = null;
        String author = null;
        String description = null;
        int yearOfRelease = 0;
        while (true) {
            System.out.println("________________________________________________________________________________________");
            System.out.println("ДОБАВЛЕНИЕ КНИГИ В КНИГОТЕКУ");
            System.out.print("Введите название книги (или \"выйти\" для возвращения к предыдущему модулю): ");
            title = getInputUserAdding();
            if (title.equalsIgnoreCase("Выйти")) break;
            System.out.print("Введите жанр книги (или \"выйти\" для возвращения к предыдущему модулю): ");
            genre = getInputUserAdding();
            if (genre.equalsIgnoreCase("Выйти")) break;
            System.out.print("Введите Автора книги (или \"выйти\" для возвращения к предыдущему модулю): ");
            author = getInputUserAdding();
            boolean duplicate = false;
            for (int i = 0; i < allBooks.size(); i++) {
                if (title.equalsIgnoreCase(allBooks.get(i).getTitle()) &&
                        author.equalsIgnoreCase(allBooks.get(i).getAuthor())) {
                    System.out.println("\nВ библиотке уже есть данная книга!\n");
                    System.out.println("ID: " + allBooks.get(i).getId() + " \"" + allBooks.get(i).title + "\" " +
                            allBooks.get(i).getAuthor());
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) continue;
            if (author.equalsIgnoreCase("Выйти")) break;
            System.out.print("Введите краткое описание книги (или \"выйти\" для возвращения к предыдущему модулю): ");
            description = getInputUserAdding();
            if (description.equalsIgnoreCase("Выйти")) break;
            System.out.print("Введите год релиза книги (или \"выйти\" для возвращения к предыдущему модулю): ");
            String inputUser = getInputUserYearOfRelease();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                yearOfRelease = Integer.parseInt(inputUser);
                preAddingBook(title, genre, author, description, yearOfRelease);
                break;
            }
        }
    }

    private static String getInputUserAdding() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String getInputUserYearOfRelease() {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while (true) {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Нельзя вводить пустою строку");
            } else if (checkInputNumber(input)) {
                break;
            } else {
                System.out.print("Введите корректный год издания книги!: ");
            }
        }
        return input;
    }

    private static void preAddingBook(String title, String genre, String author, String description, int yearOfRelease) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("________________________________________________________________________________________");
            System.out.println("ПОДТВЕРЖДЕНИЕ ДОБАВЛЕНИЯ");
            System.out.println("Вы уверены, что хотите ДОБАВИТЬ книгу?");
            System.out.println();
            System.out.println("НАЗВАНИЕ КНИГИ: " + title);
            System.out.println("АВТОР: " + author);
            System.out.println("ЖАНР: " + genre);
            System.out.println("ГОД ИЗДАНИЯ: " + yearOfRelease + " год");
            System.out.println("КРАТКОЕ ОПИСАНИЕ: " + description);
            System.out.println();
            System.out.print("да / нет: ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("да")) {
                addBook(title, genre, author, description, yearOfRelease);
                break;
            } else if (input.equalsIgnoreCase("нет")) break;
            else {
                System.out.println(errorNoChoicePage);
            }
        }
    }

    private static void addBook(String title, String genre, String author, String description, int yearOfRelease) {
        countBooks++;
        Book book = new Book(title, genre, author, description, yearOfRelease);
        allBooks.add(book);
        System.out.println("________________________________________________________________________________________");
        System.out.println("КНИГА УСПЕШНО ДОБАВЛЕНА!");
        System.out.println("УНИКАЛЬНЫЙ ID КНИГИ: " + book.getId());
    }

    private static void removeBookPage() {
        int maxID = 0;
        while (true) {
            System.out.println("________________________________________________________________________________________");
            System.out.println("УДАЛЕНИЕ КНИГИ ПО ID");
            System.out.println();
            for (int i = 0; i < allBooks.size(); i++) {
                System.out.println("ID КНИГИ: " + allBooks.get(i).getId() + " \"" +
                        allBooks.get(i).title + "\" " + allBooks.get(i).author);
                if (maxID < allBooks.get(i).getId()) {
                    maxID = allBooks.get(i).getId();
                }
            }
            String inputUser = getInputUser();
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                int inputUserInt = Integer.parseInt(inputUser);
                if (inputUserInt < 1 || inputUserInt > maxID) System.out.println(errorNoChoicePage);
                else {
                    preRemove(inputUserInt);
                    break;
                }
            }
        }
    }

    private static void preRemove(int input) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < allBooks.size(); i++) {
            if (input == allBooks.get(i).getId()) {
                System.out.println("________________________________________________________________________________________");
                System.out.println("ВЫ УВЕРЕНЫ ЧТО ХОТИТЕ УДАЛИТЬ ЭТУ КНИГУ?");
                System.out.println();
                System.out.println("ID КНИГИ: " + allBooks.get(i).getId());
                System.out.println("НАЗВАНИЕ КНИГИ: " + allBooks.get(i).getTitle());
                System.out.println("АВТОР: " + allBooks.get(i).getAuthor());
                System.out.println("ЖАНР: " + allBooks.get(i).getGenre());
                System.out.println("ГОД ИЗДАНИЯ: " + allBooks.get(i).getYearOfRelease());
                System.out.println("КРАТКОЕ ОПИСАНИЕ: " + allBooks.get(i).getDescription());
                System.out.print("да / нет: ");
                String inputUser = scanner.nextLine();
                if (inputUser.equalsIgnoreCase("да")) {
                    removeBook(input);
                    break;
                } else if (inputUser.equalsIgnoreCase("нет")) break;
                else {
                    System.out.println(errorNoChoicePage);
                }
                break;
            }
        }
    }

    private static void removeBook(int input) {
        for (int i = 0; i < allBooks.size(); i++) {
            if (input == allBooks.get(i).getId()) {
                allBooks.remove(i);
                System.out.println("________________________________________________________________________________________");
                System.out.println("КНИГА УСПЕШНО УДАЛЕНА!");
                break;
            }
        }
    }
}
