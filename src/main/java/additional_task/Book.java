package additional_task;

import java.util.*;

public class Book {
    private int id;
    private String title;
    private String genre;
    private String author;
    private String description;
    private int yearOfRelease;

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

    private static int countBooks = 0;
    private static Map<Integer, Book> books = new HashMap<>();
    static private final String errorNoChoicePage = "\nТакого варианта выбора нет, убедитесь, что ввели " +
            "верные данные и повторите попытку...";
    static private final String defaultInfoForInput = "Пожалуйста, выберите вариант действия: ";
    static private final String line = "________________________________________________________________________________________";

    public Book(String title, String genre, String author, String description, int yearOfRelease) {
        countBooks++;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.description = description;
        this.yearOfRelease = yearOfRelease;
        this.id = countBooks;
    }

    private static void initFirstBook() {
        Book book1 = new Book("Оно", "Ужасы", "Стивен Кинг",
                "Загадочная история о инопланетном монстре, который кошмарит небольшой город " +
                        "пожирая детей...", 1986);
        books.put(countBooks, book1);
        Book book2 = new Book("Гарри Поттер", "Фентези", "Джоан Роулинг",
                "Волшебная история о мальчике живущем под лестницей (Не то, что бы ему нравилось)" +
                        ", жизнь которого изменилась в 10 лет...",
                1997);
        books.put(countBooks, book2);
        Book book3 = new Book("До встречи с тобой", "Драма", "Джоджо Мойес",
                "История любви на коляске...",
                2012);
        books.put(countBooks, book3);
        Book book4 = new Book("Властелин колец", "Фентези", "Джон Рональд Руэл Толкин",
                "История о \"человеке\", который бы никогда не стал баскетболистом, в итоге и не стал...",
                1955);
        books.put(countBooks, book4);
        Book book5 = new Book("Голодные игры", "Роман", "Сьюзен Коллинз",
                "Либо ты, либо тебя, хорошо если попадешься с парнем, который буллил тебя в 5 классе...",
                2008);
        books.put(countBooks, book5);
        Book book6 = new Book("Чарли и Шоколадная фабрика", "Фентези", "Роальд Даль",
                "История о мальчике, у который полный рот коренных зубов, с которыми придется попрощаться",
                1964);
        books.put(countBooks, book6);
        Book book7 = new Book("Сумерки", "Роман", "Стефани Майер",
                "Вампиры верят, что самые праведные из них после смерти попадают на станцию переливания крови",
                2005);
        books.put(countBooks, book7);
        Book book8 = new Book("Зеленая миля", "Роман", "Стивен Кинг",
                "Даже писать нечего...реально грустно", 1996);
        books.put(countBooks, book8);
        Book book9 = new Book("Побег из Шоушенка", "Криминал/драма", "Стивен Кинг",
                "История про последствие \"Cвободы слова\"", 1982);
        books.put(countBooks, book9);
        Book book10 = new Book("Бойцовский клуб", "Криминал/драма", "Чак Паланик",
                "Первое правило бойцовского клуба...", 1996);
        books.put(countBooks, book10);
    }

    public static void main(String[] args) {
        initFirstBook();
        printWelcome();
        while (true) {
            printHomePage();
            String inputUser = getInputUser(defaultInfoForInput);
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                switch (inputUser) {
                    case "1":
                        searchBookPage();
                        break;
                    case "2":
                        addBookPage();
                        break;
                    case "3":
                        removeBookPage();
                        break;
                    case "4":
                        printAllBookPage();
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
        System.out.println("\t ДОБРО ПОЖАЛОВАТЬ В КНИЖНУЮ КАРТОТЕКУ ГУНИНА Д. А.");
        System.out.println("\n***************************************************************");
        System.out.println("***************************************************************");
        System.out.println("***************************************************************\n");
    }

    private static void printHomePage() {
        System.out.println("________________________________________________________________________________________");
        System.out.println("Пожалуйста выберите страницу из предложенных: ");
        System.out.println();
        System.out.println("1. Поиск книги");
        System.out.println("2. Добавить книгу");
        System.out.println("3. Удалить книгу");
        System.out.println("4. Показать всю коллекцию книг");
    }

    private static void printBook(Book book) {
        System.out.println(line);
        System.out.println();
        System.out.println("ID КНИГИ: " + book.getId());
        System.out.println("НАЗВАНИЕ КНИГИ: " + book.getTitle());
        System.out.println("АВТОР: " + book.getAuthor());
        System.out.println("ЖАНР: " + book.getGenre());
        System.out.println("ГОД ИЗДАНИЯ: " + book.getYearOfRelease());
        System.out.println("КРАТКОЕ ОПИСАНИЕ: " + book.getDescription());
    }

    private static void searchBookPage() {
        String infoComment;
        String typeSearch;
        while (true) {
            System.out.println("________________________________________________________________________________________");
            System.out.println("ВЫБОР ВАРИАНТА ПОИСКА");
            System.out.println();
            System.out.println("1. Поиск книги по названию");
            System.out.println("2. Поиск книги по автору");
            System.out.println("3. Поиск книги по жанру");
            System.out.println("4. Поиск книги по году издания");
            String inputUser = getInputUser(defaultInfoForInput);
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            else {
                switch (inputUser) {
                    case "1":
                        infoComment = "Введите полное название книги (Например: Оно) : ";
                        typeSearch = "ПОИСК ПО НАЗВАНИЮ";
                        searchBook(infoComment, typeSearch);
                        break;
                    case "2":
                        infoComment = "Введите имя и фамилию автора (Например: Стивен Кинг): ";
                        typeSearch = "ПОИСК ПО АВТОРУ";
                        searchBook(infoComment, typeSearch);
                        break;
                    case "3":
                        infoComment = "Введите жанр книги, которую вы ищите (Например: Ужасы, Драма): ";
                        typeSearch = "ПОИСК ПО ЖАНРУ";
                        searchBook(infoComment, typeSearch);
                        break;
                    case "4":
                        infoComment = "Введите год издания книги (Например: 1982): ";
                        typeSearch = "ПОИСК ПО ГОДУ ИЗДАНИЯ";
                        searchBook(infoComment, typeSearch);
                        break;
                    default:
                        System.out.println(errorNoChoicePage);
                }
                break;
            }
        }
    }

    private static void searchBook(String infoComment, String typeSearch) {
        boolean haveSearchBook = false;
        while (true) {
            System.out.println(line);
            System.out.println(typeSearch);
            String inputUser = getInputUser(infoComment);
            if (inputUser.equalsIgnoreCase("Выйти")) break;
            switch (typeSearch) {
                case "ПОИСК ПО НАЗВАНИЮ":
                    for (Map.Entry<Integer, Book> entry : books.entrySet()) {
                        if (inputUser.equalsIgnoreCase(entry.getValue().getTitle())) {
                            printBook(entry.getValue());
                            haveSearchBook = true;
                        }
                    }
                    if (!haveSearchBook) System.out.println(errorNoChoicePage);
                    break;
                case "ПОИСК ПО АВТОРУ":
                    for (Map.Entry<Integer, Book> entry : books.entrySet()) {
                        if (inputUser.equalsIgnoreCase(entry.getValue().getAuthor())) {
                            printBook(entry.getValue());
                            haveSearchBook = true;
                        }
                    }
                    if (!haveSearchBook) System.out.println(errorNoChoicePage);
                    break;
                case "ПОИСК ПО ЖАНРУ":
                    for (Map.Entry<Integer, Book> entry : books.entrySet()) {
                        if (inputUser.equalsIgnoreCase(entry.getValue().getGenre())) {
                            printBook(entry.getValue());
                            haveSearchBook = true;
                        }
                    }
                    if (!haveSearchBook) System.out.println(errorNoChoicePage);
                    break;
                case "ПОИСК ПО ГОДУ ИЗДАНИЯ":
                    int inputUserYear;
                    if (checkInputNumber(inputUser)) {
                        inputUserYear = Integer.parseInt(inputUser);
                    } else {
                        System.out.println(errorNoChoicePage);
                        break;
                    }
                    for (Map.Entry<Integer, Book> entry : books.entrySet()) {
                        if (inputUserYear == entry.getValue().getYearOfRelease()) {
                            printBook(entry.getValue());
                        }
                    }
                    break;
            }
        }
    }

    private static String getInputUser(String infoComment) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println();
            System.out.print(infoComment + " (или введите \"Выйти\" для выхода): ");
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("\nНельзя вводить пустую строку!");
            } else break;
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

    private static void addBookPage() {
        String InfoTitle = "Введите название книги (Например: В далеком крае): ";
        String InfoAuthor = "Введите автора книги (Например: Стивен Кинг): ";
        String InfoYearOfRelease = "Введите год издания книги (Например: 1982): ";
        String InfoGenre = "Введите жанр книги (Например: Роман): ";
        String InfoDescription = "Введите краткое описание книги: ";
        System.out.println(line);
        System.out.println("ДОБАВЛЕНИЕ КНИГИ");
        String title = getInputUser(InfoTitle);
        String author = getInputUser(InfoAuthor);
        int yearOfRelease = 0;
        String input;
        while (true) {
            input = getInputUser(InfoYearOfRelease);
            if (checkInputNumber(input)) {
                yearOfRelease = Integer.parseInt(input);
                if (yearOfRelease > 2023) {
                    System.out.println("\nГод не может быть больше текущего!");
                }
                break;
            } else System.out.println("\nОШИБКА ВВОДА! Должно быть введено число!");
        }
        String genre = getInputUser(InfoGenre);
        String description = getInputUser(InfoDescription);
        Book book = new Book(title, genre, author, description, yearOfRelease);
        System.out.println(line);
        System.out.println("КНИГА УСПЕШНО ДОБАВЛЕНА");
        books.put(countBooks, book);
        printBook(book);
    }

    private static void removeBookPage() {
        while (true) {
            System.out.println(line);
            System.out.println("УДАЛЕНИЕ КНИГИ");
            String infoComment = "Введите ID книги, которую хотите удалить: ";
            int bookId = 0;
            String input;
            while (true) {
                input = getInputUser(infoComment);
                if (input.equalsIgnoreCase("Выйти")) break;
                else if (checkInputNumber(input)) {
                    bookId = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("\nОШИБКА ВВОДА! Должно быть введено число!");
                }
                if (input.equalsIgnoreCase("Выйти")) break;
            }
            boolean notHaveId = false;
            for (Map.Entry<Integer, Book> entry : books.entrySet()) {
                if (bookId != entry.getKey()) notHaveId = true;
                if (bookId == entry.getKey()) {
                    notHaveId = false;
                    System.out.println("ВЫ УВЕРЕНЫ, ЧТО ХОТИТЕ УДАЛИТЬ ДАННУЮ КНИГУ?:");
                    printBook(entry.getValue());
                    input = getInputUser("Введите да / нет: ");
                    if (input.equalsIgnoreCase("нет")) break;
                    else if (input.equalsIgnoreCase("да")) {
                        books.remove(entry.getKey());
                        break;
                    }
                }
            }
            if (notHaveId) {
                System.out.println("\nКниги с таким ID нет!");
            }
            break;
        }
    }

    private static void printAllBookPage() {
        for (Map.Entry<Integer, Book> entry : books.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " \"" + entry.getValue().getTitle() + "\" " +
                    entry.getValue().getAuthor() + ", жанр: " + entry.getValue().getGenre() + ", год издания: " +
                    entry.getValue().getYearOfRelease());
        }
    }
}
