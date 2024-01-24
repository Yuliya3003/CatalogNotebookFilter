import java.util.*;

public class CatalogNotebook {

    public static HashMap<Integer, String> makeCriteriaMap(){
        HashMap<Integer, String> criteriaNotebook = new HashMap<>();
        criteriaNotebook.put(1, "Объем жесткого диска");
        criteriaNotebook.put(2, "Объем оперативной памяти");
        criteriaNotebook.put(3, "Производитель");
        criteriaNotebook.put(4, "Операционная система");
        criteriaNotebook.put(5, "Диагональ экрана");
        return criteriaNotebook;
    }

    public static Set<Notebook> createSetOfNotebook(){
        Notebook notebook1 = new Notebook(512, 16, "Apple", "macOS", 13.3);
        Notebook notebook2 = new Notebook(1000, 32, "Asus", "Windows 10", 17.3);
        Notebook notebook3 = new Notebook(256, 8, "Acer", "Chrome OS", 14.0);
        Notebook notebook4 = new Notebook(1000, 16, "Dell", "Ubuntu", 15.6);
        Notebook notebook5 = new Notebook(512, 32, "HP", "Windows 11", 13.3);
        Notebook notebook6 = new Notebook(256, 8, "Lenovo", "Windows 10", 15.6);
        Notebook notebook7 = new Notebook(500, 16, "Microsoft", "Windows 10", 12.3);
        Notebook notebook8 = new Notebook(1000, 32, "Samsung", "Windows 10", 13.3);
        Notebook notebook9 = new Notebook(256, 8, "Toshiba", "Windows 10", 15.6);
        Notebook notebook10 = new Notebook(512, 16, "Sony", "Windows 10", 14.0);
        Notebook notebook11 = new Notebook(1000, 32, "LG", "Windows 10", 15.6);
        Notebook notebook12 = new Notebook(256, 8, "Fujitsu", "Windows 10", 13.3);
        Notebook notebook13 = new Notebook(500, 8, "HP", "Windows 10", 15.6);
        Notebook notebook14 = new Notebook(1000, 16, "Dell", "Ubuntu", 14.0);
        Notebook notebook15 = new Notebook(256, 4, "Lenovo", "Windows 11", 13.3);
        Set<Notebook> catalogNotebook = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3,
                notebook4, notebook5, notebook6, notebook7, notebook8, notebook9, notebook10, notebook11,
                notebook12, notebook13, notebook14, notebook15));
        return catalogNotebook;
    }
    public static void filterCriteriaNotebook(Set<Notebook> catalogNotebook) {
        HashMap<Integer, String> criteriaNotebook = makeCriteriaMap();
        System.out.println("Введите критерии для поиска цифрами из списка через пробел:");
        System.out.println(criteriaNotebook);
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] criteries = input.split(" ");
        HashMap<String, Object> filterCriteries = new HashMap<>();

        for (String criteria : criteries) {
            switch (criteria) {
                case "1":
                    System.out.println("Введите минимальное значение объема жесткого диска в Гб:");
                    int hddFilter = scanner.nextInt();
                    filterCriteries.put("hardDiskCapacity", hddFilter);
                    scanner.nextLine();
                    break;
                case "2":
                    System.out.println("Введите минимальное значение объема оперативной памяти в Гб:");
                    int ramFilter = scanner.nextInt();
                    filterCriteries.put("amountOfRAM", ramFilter);
                    scanner.nextLine();
                    break;
                case "3":
                    System.out.println("Выберите необходимого производителя: Apple, Asus, Acer, Dell, HP, Lenovo, Microsoft, Samsung, Toshiba, Sony, LG, Fujitsu.");
                    String manufacturerFilter = scanner.nextLine();
                    filterCriteries.put("manufacturer", manufacturerFilter);
                    break;
                case "4":
                    System.out.println("Введите необходимую операционную систему: macOS, Windows 10, Chrome OS, Ubuntu, Windows 11.");
                    String osFilter = scanner.nextLine();
                    filterCriteries.put("operatingSystem", osFilter);
                    break;
                case "5":
                    System.out.println("Введите минимальное значение диагонали экрана через . (больше 12.3 дюймов):");
                    double screenDiagonalFilter = Double.parseDouble(scanner.nextLine());
                    filterCriteries.put("screenDiagonal", screenDiagonalFilter);
                    break;
                default:
                    System.out.println("Некорректный выбор критерия.");
                    return;
            }
        }
        Set<Notebook> filteredNotebooks = filterNotebooks(catalogNotebook, filterCriteries);

        System.out.println("Результаты фильтрации:");
        for (Notebook notebook : filteredNotebooks) {
            System.out.println(notebook.toString());
        }
    }


    private static Set<Notebook> filterNotebooks(Set<Notebook> catalogNotebook, Map<String, Object> filterCriteria) {
        Set<Notebook> filteredNotebooks = new HashSet<>();

        for (Notebook notebook : catalogNotebook) {
            boolean meetsCriteria = true;

            for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                switch (key) {
                    case "hardDiskCapacity":
                        if (notebook.getHardDiskCapacity() < (int) value) {
                            meetsCriteria = false;
                        }
                        break;
                    case "amountOfRAM":
                        if (notebook.getAmountOfRAM() < (int) value) {
                            meetsCriteria = false;
                        }
                        break;
                    case "manufacturer":
                        if (!notebook.getManufacturer().equalsIgnoreCase((String) value)) {
                            meetsCriteria = false;
                        }
                        break;
                    case "operatingSystem":
                        if (!notebook.getOperatingSystem().equalsIgnoreCase((String) value)) {
                            meetsCriteria = false;
                        }
                        break;
                    case "screenDiagonal":
                        if (notebook.getScreenDiagonal() < (double) value) {
                            meetsCriteria = false;
                        }
                        break;
                }
            }

            if (meetsCriteria) {
                filteredNotebooks.add(notebook);
            }
        }

        return filteredNotebooks;
    }

}

