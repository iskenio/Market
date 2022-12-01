package Services.impl;

import Market.Market;
import Services.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;


public class CrudServiceImpl implements CrudService {
    void choice(){
        System.out.println("Выберите действие ");
        System.out.println("1. сохранить");
        System.out.println("2. вывести все");
        System.out.println("3. вывести по айди");
        System.out.println("4. редактировать");
        System.out.println("5. удалить");
    }
    ShopServices shopService=new MarketServImpl();
    CategoryServices categoryServices = new CategoryServicesImpl();
    ProductServices productServices = new ProductServicesImpl();
    UsersServices usersServices = new UsersServicesImpl();
    CheckService checkService = new CheckServiceImpl();
    CheckProductService checkProductService = new CheckProductServiceImpl();
    MarketCategoryService marketCategoryService = new MarketCategoryServiceImpl();
    Scanner scanner=new Scanner(System.in);

    @Override
    public void getShopControl() {
        choice();

        switch (scanner.nextInt()){
            case 1:
                shopService.create();
                break;
            case 2:
                System.out.println(shopService.findAll());
                break;
            case 3:
                System.out.println("Введите ID ");
                System.out.println(shopService.findById(scanner.nextLong()));
                break;
            case 4:
                System.out.println("Введите ID магазина: ");
                long id = scanner.nextLong();
                System.out.println("Введите название магазина: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                shopService.update(name, id);
                //shopService.update(scanner.nextLong(), scanner.next());
                break;
            case 5:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                shopService.delete(id);
                break;
            default: break;

        }
    }

    @Override
    public void getCategoryControl() {
        Long id;
        choice();
        switch (scanner.nextInt()){
            case 1:
                categoryServices.create();
                break;
            case 2:
                System.out.println(categoryServices.findAll());
                break;
            case 3:
                System.out.println("Введите ID ");
                id = scanner.nextLong();
                System.out.println(categoryServices.findById(id));
                break;
            case 4:
                System.out.println("Введите id категории: ");
                id = scanner.nextLong();
                System.out.println("Введите название категории: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                categoryServices.update(id, name);
                break;
            case 5:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                categoryServices.delete(id);
                break;

            default:break;
        }
    }

    @Override
    public void getProductControl() {
        choice();


        switch (scanner.nextInt()){
            case 1:
                productServices.create();
                break;
            case 2:
                System.out.println(productServices.findAll());
                break;
            case 3:
                System.out.println("Введите ID ");
                Long id = scanner.nextLong();
                System.out.println(productServices.findById(id));
                break;
            case 4:
                System.out.println("Введите название продукта: ");
                id = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Введите цену продукта: ");
                double price = scanner.nextDouble();
                productServices.update(id, price);
                break;
            case 5:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                productServices.delete(id);
            default: break;
        }
    }

    @Override
    public void getUserControl() {
        choice();
        Long id;
        switch (scanner.nextInt()){
            case 1:
                usersServices.create();
                break;
            case 2:
                System.out.println(usersServices.findAll());
                break;
            case 3:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                System.out.println(usersServices.findById(id));
            break;
            case 4:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Введите name: ");
                String name = scanner.nextLine();
                usersServices.update(name, id);
                break;
            case 5:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                usersServices.delete(id);
            default: break;
        }
    }

    @Override
    public void getCheckControl() throws SQLException {
        choice();
        Long id;
        switch (scanner.nextInt()){
            case 1:
                System.out.println("Введите сумму: ");
                checkService.save(scanner.nextInt());
                break;
            case 2:
                System.out.println(checkService.findAll());
                break;
            case 3:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                System.out.println(checkService.findById(id));
                break;
            case 4:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Введите sum: ");
                int total_sum = scanner.nextInt();
                checkService.update(total_sum, id);
                break;
            case 5:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                checkService.delete(id);
            default: break;
        }

    }

    @Override
    public void getCheckProductControl() throws SQLException {
        choice();
        Long id;
        switch (scanner.nextInt()){
            case 1:
                System.out.println("Введите id чека ");
                int checkId = scanner.nextInt();
                System.out.println("Введите id продукта ");
                int productId = scanner.nextInt();
                System.out.println("Введите сумму ");
                int sum = scanner.nextInt();
                checkProductService.save(checkId, productId, sum);
                break;
            case 2:
                checkProductService.findAll();
                break;
            case 3:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                checkProductService.findById(id);
                break;
            case 4:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Введите sum: ");
                int count = scanner.nextInt();
                checkProductService.update(id, count);
                break;
            case 5:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                checkProductService.delete(id);
            default: break;
        }



    }

    @Override
    public void getMarketCategoryControl() throws SQLException {
        choice();
        Long id;
        switch (scanner.nextInt()){
            case 1:

                //marketCategoryService. checkId = scanner.nextInt();
                System.out.println("Введите id магазина ");
                Long marketId = scanner.nextLong();
                System.out.println("Введите id категории ");
                Long categoryId = scanner.nextLong();
                marketCategoryService.save(marketId, categoryId);
                break;
            case 2:

                System.out.println(marketCategoryService.findAll());
                break;
            case 3:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                System.out.println(marketCategoryService.findById(id));
                break;
            case 4:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                scanner.nextLine();
                System.out.println("Введите id категории: ");
                Long category_id = scanner.nextLong();
                marketCategoryService.update(id, category_id);
                break;
            case 5:
                System.out.println("Введите ID: ");
                id = scanner.nextLong();
                marketCategoryService.delete(id);
            default: break;
        }
    }
}
