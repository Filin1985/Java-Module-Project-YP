import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Calculator {
    int personsToSplit;
    double totalPrice = 0;

    double pricePerPerson = 0;
    ArrayList<Product> products = new ArrayList<>();

    public void start() {
        while(true) {
            System.out.println("Добрый день! На сколько человек разделить счет?");
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()) {
                personsToSplit = scanner.nextInt();
                if(personsToSplit == 1) {
                    System.out.println("Для одного человека нет смысла делить счет. Платите весь счет сами или введите корректное значение!");
                } else if(personsToSplit <  1) {
                    System.out.println("Количество персон не может быть 0. Введите корректное значение!");
                } else {
                    calculate();
                    break;
                }
            } else {
                System.out.println("Вы ввели некорректную команду. Необходимо ввести число!");
            }
        }
    }

    public void calculate() {
        getProductData();
        printProducts();
        calculatePricePerPerson();
        System.out.println(Formatter.formatMessage(pricePerPerson));
    }

    public void getProductData() {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Введите пожалуйста наименование товара: ");
            String productName = scanner.next();

            System.out.println("Введите стоимость товара в формате 'рубли.копейки': ");
            double productPrice = scanner.nextDouble();
            while(productPrice < 0) {
                System.out.println("Отрицательной стомости товара не существует. Введите валидные данные: ");
                productPrice = scanner.nextDouble();
            }

            addProduct(productName, productPrice);

            System.out.println("Хотите ли вы добавить еще товар? (Если нет то введите команду 'Завершить'): ");
            String command = scanner.next();
            if (command.equalsIgnoreCase("завершить")) {
                break;
            }
        }
    }

    public void addProduct(String name, double price) {
        Product newProduct = new Product(name, price);
        products.add(newProduct);
        totalPrice += price;
        System.out.println("Добавленные товары: " + newProduct.name);
    }

    public void calculatePricePerPerson() {
        pricePerPerson = totalPrice / personsToSplit;
    }

    public void printProducts() {
        System.out.println("Товары в калькуляторе:");
        for(Product product: products) {
            System.out.println(product.name);
        }
    }
}
