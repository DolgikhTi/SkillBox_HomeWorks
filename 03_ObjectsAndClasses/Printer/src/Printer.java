public class Printer
{
    private static String queue = "";
    private static int PagesCount = 0;
    private static int DocumentsCount = 0;

    public static void main(String[] args)
    {
        append("Загранпаспорт", 3, 65);
        append("Диплом о высшем образовании", 5, 50);
        append("Трудовая книжка", 7, 120);
        print("Список документов на печать:");
        int PagesCount = getPagesCount();
        int DocumentsCount = getDocumentsCount();
        int PagesAndDocumentsCount = totalPagesAndDocumentsCount();
        System.out.println("Общее количество страниц:" + PagesCount);
        System.out.println("Общее количество документов:" + DocumentsCount);
        System.out.println("Общее количество распечатанных страниц и документов:" +
                PagesAndDocumentsCount);
        clear();
        System.out.println();
        print("Список документов на печать:");
        DocumentsCount = getDocumentsCount();
        PagesCount = getPagesCount();
        System.out.println("Общее количество страниц:" + PagesCount);
        System.out.println("Общее количество документов:" + DocumentsCount);
    }

    public static void append(String name)
    {
        append(name, 1);
    }

    public static void append(String name, int dokuments)
    {
        append(name, 1, 1);
    }

    public static void append(String name, int dokuments, int pages)
    {
        queue = queue + "\n" + name + " - " + dokuments + " шт." +
                " - " + pages + " стр.";
        PagesCount = PagesCount + pages;
        DocumentsCount = DocumentsCount + dokuments;
    }

    public static void clear()
    {
        queue = "";
        PagesCount = 0;
        DocumentsCount = 0;
    }

    public static int getPagesCount()
    {
        return PagesCount;
    }

    public static int getDocumentsCount()
    {
        return DocumentsCount;
    }

    public static int totalPagesAndDocumentsCount()
    {
        return PagesCount + DocumentsCount;
    }

    public static void print(String title)
    {
        System.out.println(title);
        if (queue.isEmpty()){
            System.out.println("Список пуст");
        } else {
            System.out.println(queue);
        }
    }
}
