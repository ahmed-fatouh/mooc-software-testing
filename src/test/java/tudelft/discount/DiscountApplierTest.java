package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class DiscountApplierTest {

    private List<Product> products;
    private DiscountApplier discountApplier;

    @BeforeEach
    public void Initialize(){
        Product p1 = new Product("Printer X", 200, "");
        Product p2 = new Product("Printer X", 0, "");
        Product p3 = new Product("Printer X", -200, "");
        products = Arrays.asList(p1, p2, p3);

        ProductDao dao = Mockito.mock(ProductDao.class);
        Mockito.when(dao.all()).thenReturn(products);
        discountApplier = new DiscountApplier(dao);
    }

    private void setProductsCategory(String category){
        for(Product p : products){
            p.setCategory(category);
        }
    }

    @ParameterizedTest
    @CsvSource({"0,200", "1,0", "2,-200"})
    public void productIsForBusiness(int index, double initialPrice){
        setProductsCategory("BUSINESS");
        discountApplier.setNewPrices();
        Assertions.assertEquals(initialPrice * 1.1, products.get(index).getPrice());
    }

    @ParameterizedTest
    @CsvSource({"0,200", "1,0", "2,-200"})
    public void productIsForHome(int index, double initialPrice){
        setProductsCategory("HOME");
        discountApplier.setNewPrices();
        Assertions.assertEquals(initialPrice * 0.9, products.get(index).getPrice());
    }
}
