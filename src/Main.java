import Market.Product;
import Services.CrudService;
import Services.impl.CrudServiceImpl;
import Services.impl.ProductServicesImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        CrudService crudService=new CrudServiceImpl();
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("Выберите действие ");
            System.out.println("1 справочник ");
            System.out.println("2 операции  ");

            if (scanner.nextInt()==1){
                System.out.println("Выберите справочник ");
                System.out.println("1. Магазин");
                System.out.println("2. Категории");
                System.out.println("3. Продукты");
                System.out.println("4. Пользователь");
                System.out.println("5. Чеки");
                System.out.println("6. Чек покупки");
                System.out.println("7. Магазин/Категории");


                switch (scanner.nextInt()){
                    case 1:
                        crudService.getShopControl();
                        break;
                    case 2:
                        crudService.getCategoryControl();
                        break;
                        //TODO прописать далее
                    case 3:
                        crudService.getProductControl();
                        break;
                    case 4:
                        crudService.getUserControl();
                        break;
                    case 5:
                        crudService.getCheckControl();
                        break;
                    case 6:
                        crudService.getCheckProductControl();
                        break;
                        case 7:
                        crudService.getMarketCategoryControl();
                        break;

                    default:break;
                }
            }
        }
    }
}
