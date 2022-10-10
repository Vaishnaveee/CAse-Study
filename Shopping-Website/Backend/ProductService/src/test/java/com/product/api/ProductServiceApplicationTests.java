/*
 * package com.product.api;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.junit.Assert.assertEquals; import static org.junit.Assert.assertNull;
 * import static org.mockito.Mockito.times; import static
 * org.mockito.Mockito.verify; import static org.mockito.Mockito.when;
 * 
 * import java.util.ArrayList; import java.util.List; import
 * java.util.stream.Collectors; import java.util.stream.Stream;
 * 
 * import org.junit.Before; import org.junit.jupiter.api.Test; import
 * org.junit.runner.RunWith; import org.mockito.InjectMocks; import
 * org.mockito.Mock;
 * 
 * import org.springframework.boot.test.context.SpringBootTest;
 * 
 * import org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.product.api.controller.ProductController; import
 * com.product.api.model.Product; import
 * com.product.api.repository.ProductRepository; import org.mockito.Mockito;
 * 
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest class ProductServiceApplicationTests {
 * 
 * @InjectMocks private ProductController productController;
 * 
 * @Before void initTest() {
 * productController=Mockito.mock(ProductController.class); }
 * 
 * @Mock private ProductRepository productRepository;
 * 
 * //Check test for size of list of products
 * 
 * @Test public void getProductTest() {
 * when(productRepository.findAll()).thenReturn(Stream .of(new Product(1,
 * "Electronics","TV", "household",4, "good", 30000, null, null), new Product(2,
 * "Electronics", "AC","household", 3, "better", 10000, null,
 * null)).collect(Collectors.toList())); assertEquals(2,
 * productController.getProduct().size()); } //Check test for null list or empty
 * list
 * 
 * @Test void getProductNull() {
 * 
 * Mockito.when(productRepository.findAll().equals(null)).thenReturn(null);
 * assertEquals(null, productController.getProduct());
 * 
 * 
 * }
 * 
 * //Check test for adding new product
 * 
 * @Test public void addProductTest() { Product product = new Product(3,
 * "Electronics","Heater", "household",5, "good", 15000, null, null);
 * when(productRepository.save(product)).thenReturn(product);
 * assertEquals(product, productController.addProduct(product)); } // Check test
 * for get all Products
 * 
 * @Test void getUserTest1() { List<Product> List = new ArrayList<>();
 * 
 * List.add(new Product(3, "Electronics","Heater", "household",5, "good", 15000,
 * null, null)); List.add(new Product(3, "Electronics","Heater", "household",5,
 * "good", 15000, null, null)); List.add(new Product(3, "Electronics","Heater",
 * "household",5, "good", 15000, null, null));
 * 
 * when(productRepository.findAll()).thenReturn(List);
 * 
 * assertEquals(List, productController.getProduct()); }
 * 
 * 
 * //Check Test for delete product
 * 
 * @Test public void deleteProductTest() { Product product = new Product(3,
 * "Electronics","Heater", "household", 4, "good", 25000, null, null); when
 * (productRepository.getById((long) 1)).thenReturn(product);
 * productController.deleteProduct((long) 1); verify(productRepository,
 * times(1)).deleteById((long) 1); }
 * 
 * //Check Test for delete product-Alternative
 * 
 * @Test public void deleteProductTest1() { Long product = (long) 1;
 * productController.deleteProduct(product); verify(productRepository,
 * times(1)).deleteById(product); }
 * 
 * //Check test for updating product public void UpdateProductTest() { Product
 * product=new Product(3, "Electronics","Heater", "household", 4, "good", 25000,
 * null, null); when(productRepository.getById((long) 1)).thenReturn(product);
 * 
 * String productType= "Electronics"; String productName="Heater"; String
 * category="Household"; int rating=2; String review="Better"; double
 * price=12000; String description=null; String specification=null;
 * 
 * Product pro=new Product( 0, productType, productName, category, rating,
 * review, price, description, specification);
 * when(productController.updateProduct((long)1, pro, null)).thenReturn(pro);
 * 
 * assertThat(product.getProductType()).isEqualTo(productType);
 * assertThat(product.getProductName()).isEqualTo(productName);
 * assertThat(product.getCategory()).isEqualTo(category);
 * assertThat(product.getRating()).isEqualTo(rating);
 * assertThat(product.getReview()).isEqualTo(review);
 * assertThat(product.getPrice()).isEqualTo(price);
 * assertThat(product.getDescription()).isEqualTo(description);
 * assertThat(product.getSpecification()).isEqualTo(specification);
 * 
 * 
 * } //Check test for null parameter from list
 * 
 * @Test void GetuserTest2() throws InvalidException {
 * 
 * List<Product> list = productController.getProduct();
 * 
 * for (Product p : list) { if (p.getId() == 0) {
 * 
 * Mockito.when(p.getId() == 0).thenThrow(InvalidException.class);
 * 
 * } else if (p.getProductType().equals(null)) {
 * 
 * Mockito.when(p.getProductType().equals(null)).thenThrow(InvalidException.
 * class);
 * 
 * assertNull(p.getProductType());
 * 
 * } else if (p.getProductName().equals(null)) {
 * 
 * Mockito.when(p.getProductName().equals(null)).thenThrow(InvalidException.
 * class);
 * 
 * assertNull(p.getProductName());
 * 
 * } else if (p.getCategory().equals(null)) {
 * 
 * Mockito.when(p.getCategory().equals(null)).thenThrow(InvalidException.class);
 * 
 * assertNull(p.getCategory());
 * 
 * } else if (p.getRating()==0) {
 * 
 * Mockito.when(p.getRating()==0).thenThrow(InvalidException.class);
 * 
 * assertNull(p.getRating());
 * 
 * } else if (p.getReview().equals(null)) {
 * 
 * Mockito.when(p.getReview().equals(null)).thenThrow(InvalidException.class);
 * 
 * assertNull(p.getReview());
 * 
 * } else if (p.getPrice()==0) {
 * 
 * Mockito.when(p.getPrice()==0).thenThrow(InvalidException.class);
 * 
 * assertNull(p.getPrice());
 * 
 * } else if (p.getDescription().equals(null)) {
 * 
 * Mockito.when(p.getDescription().equals(null)).thenThrow(InvalidException.
 * class);
 * 
 * assertNull(p.getDescription());
 * 
 * } else if (p.getSpecification().equals(null)) {
 * 
 * Mockito.when(p.getSpecification().equals(null)).thenThrow(InvalidException.
 * class);
 * 
 * assertNull(p.getSpecification());
 * 
 * }
 * 
 * } } }
 * 
 * 
 * 
 */