import java.util.Scanner;
import java.util.Set;

public class MainNotebook {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Хотите отфильтровать каталог с ноутбуками? Y/N");
            String input = scanner.nextLine();
            input = input.toLowerCase();
            if (input.equalsIgnoreCase("y")){
                Set<Notebook> catalogNotebook = CatalogNotebook.createSetOfNotebook();
                CatalogNotebook.filterCriteriaNotebook(catalogNotebook);
            } else {break;}
        }
        scanner.close();
    }
}


