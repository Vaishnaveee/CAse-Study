/*
 * package com.profile.api;
 * 
 * import static org.assertj.core.api.Assertions.assertThat; import static
 * org.junit.Assert.assertEquals; import static org.junit.Assert.assertNull;
 * import static org.mockito.Mockito.times; import static
 * org.mockito.Mockito.verify; import static org.mockito.Mockito.when;
 * 
 * import java.time.LocalDate; import java.util.ArrayList; import
 * java.util.List; import java.util.stream.Collectors; import
 * java.util.stream.Stream;
 * 
 * import org.junit.Before;
 * 
 * import org.junit.jupiter.api.Test; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; import org.mockito.Mockito;
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.profile.api.controller.UserController; import
 * com.profile.api.model.User; import com.profile.api.repository.UserRepository;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest class ProfileServiceApplicationTests {
 * 
 * 
 * @Test void contextLoads() { }
 * 
 * 
 * @InjectMocks private UserController userController;
 * 
 * @Before void initTest() { userController =
 * Mockito.mock(UserController.class); }
 * 
 * @Mock private UserRepository userRepository;
 * 
 * @Test // testcase to check size of list of users void GetuserTest() throws
 * InvalidException {
 * 
 * Mockito.when(userRepository.findAll()) .thenReturn(Stream .of(new User(1,
 * "aditi", "9423020355", "user", "female", "xyz","abc123", LocalDate.of(2020,
 * 1, 8), "aditi@gmail.com","pika"), new User(1, "aditi", "9423020355", "user",
 * "female", "xyz","abc123", LocalDate.of(2020, 1, 8),
 * "aditi@gmail.com","pika")) .collect(Collectors.toList())); assertEquals(2,
 * userController.getalluser().size());
 * 
 * //Mockito.when(userRepository.findAll().equals(null)).thenThrow(
 * InvalidException.class); //assertEquals(null, userRepository.findAll()); }
 * 
 * @Test //testcase to check null list or empty list void Getusernull() {
 * 
 * Mockito.when(userRepository.findAll().equals(null)).thenReturn(null);
 * assertEquals(null, userController.getalluser());
 * 
 * 
 * }
 * 
 * @Test // test case for get all users void getUserTest1() { List<User> List1 =
 * new ArrayList<>();
 * 
 * List1.add(new User(1, "aditi", "9423020355", "user", "female",
 * "xyz","abc123", LocalDate.of(2000, 11, 21), "aditi@gmail.com","pika"));
 * List1.add(new User(1, "aditi", "9423020355", "user", "female",
 * "xyz","abc123", LocalDate.of(2020, 1, 8), "aditi@gmail.com","pika"));
 * List1.add(new User(1, "aditi", "9423020355", "user", "female",
 * "xyz","abc123", LocalDate.of(2020, 1, 8), "aditi@gmail.com","pika"));
 * 
 * when(userRepository.findAll()).thenReturn(List1);
 * 
 * assertEquals(List1, userController.getalluser()); }
 * 
 * @Test //testcase to check getalluser fuction test void getuserTest2() {
 * List<User> List1 = new ArrayList<>();
 * 
 * when(userRepository.findAll()).thenReturn(List1);
 * 
 * assertEquals(List1, userController.getalluser()); }
 * 
 * 
 * @Test public void getUserbyAddressTest() {
 * 
 * User user = new User(1, "aditi", "9423020355", "user", "female",
 * "xyz","abc123", LocalDate.of(2020, 1, 8), "aditi@gmail.com","pika");
 * 
 * String address = "pika"; Mockito.when(userRepository.findByUsername(address))
 * .thenReturn(user); assertEquals(user, userController.getByUsername(address));
 * 
 * //assertEquals(1,userController.getByUsername(address));
 * 
 * }
 * 
 * 
 * @Test public void getUserbyId() {
 * 
 * User user = new User(1, "aditi", "9423020355", "user", "female",
 * "xyz","abc123", LocalDate.of(2020, 1, 8), "aditi@gmail.com","pika");
 * when(userRepository.getById((long) 1)).thenReturn(user);
 * 
 * assertEquals(user,userController.getByUserId(1));
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * @Test //testcase to check null parameter from list void GetuserTest2() throws
 * InvalidException {
 * 
 * List<User> list = userController.getalluser();
 * 
 * for (User u : list) {
 * 
 * if (u.getEmailId().equals(null)) {
 * 
 * Mockito.when(u.getEmailId().equals(null)).thenThrow(InvalidException.class);
 * 
 * assertNull(u.getEmailId());
 * 
 * } else if (u.getAbout().equals(null)) {
 * 
 * Mockito.when(u.getAbout().equals(null)).thenThrow(InvalidException.class);
 * 
 * assertNull(u.getAbout());
 * 
 * } else if (u.getMobilenumber().equals(null)) {
 * 
 * Mockito.when(u.getMobilenumber().equals(null)).thenThrow(InvalidException.
 * class);
 * 
 * assertNull(u.getMobilenumber());
 * 
 * } else if (u.getFullName().equals(null)) {
 * 
 * Mockito.when(u.getFullName().equals(null)).thenThrow(InvalidException.class);
 * 
 * assertNull(u.getFullName());
 * 
 * } else if (u.getRole().equals(null)) {
 * 
 * Mockito.when(u.getRole().equals(null)).thenThrow(InvalidException.class);
 * 
 * assertNull(u.getRole());
 * 
 * } else if (u.getDateOfBirth().equals(null)) {
 * 
 * Mockito.when(u.getDateOfBirth().equals(null)).thenThrow(InvalidException.
 * class);
 * 
 * assertNull(u.getDateOfBirth()); // assertNull(u.getAge()); // assertEquals(0,
 * 0); } else if (u.getProfileId() == 0) {
 * 
 * Mockito.when(u.getProfileId() == 0).thenThrow(InvalidException.class);
 * 
 * // assertNull(u.getUserId()); // assertEquals(0, 0); } else if
 * (u.getGender().equals(null)) {
 * 
 * Mockito.when(u.getGender().equals(null)).thenThrow(InvalidException.class);
 * 
 * assertNull(u.getGender());
 * 
 * }else if (u.getPassword().equals(null)) {
 * 
 * Mockito.when(u.getPassword().equals(null)).thenThrow(InvalidException.class);
 * 
 * assertNull(u.getPassword());
 * 
 * }else if (u.getUsername().equals(null)) {
 * 
 * Mockito.when(u.getUsername().equals(null)).thenThrow(InvalidException.class);
 * 
 * assertNull(u.getUsername()); }
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 * @Autowired private PasswordEncoder passwordEncoder;
 * 
 * @Test // testcase for add new user void AddUserTest1(){ User user = new
 * User(1, "aditi", "9423020355", "user", "female", "xyz","abc123",
 * LocalDate.of(2020, 1, 8), "aditi@gmail.com","pika");
 * 
 * String passEncoded = passwordEncoder.encode(user.getPassword());
 * user.setPassword(passEncoded);
 * when(userRepository.save(user)).thenReturn(user);
 * //assertNull(userController.getalluser().size());
 * 
 * assertEquals(0, userController.getalluser().size()); //assertEquals(user,
 * userController.getalluser()); }
 * 
 * @Test // test case for updating user information void updateuserTest1() {
 * User user = new User(1, "aditi", "9423020355", "user", "female",
 * "xyz","abc123", LocalDate.of(2020, 1, 8), "aditi@gmail.com","pika");
 * when(userRepository.getById((long) 1)).thenReturn(user);
 * 
 * String name = "jerry"; String role = "user"; String mobile = "9536482144";
 * String email = "jerry@gmail.com"; String gender="female"; String
 * about="djfs"; String password="asds"; LocalDate DOB=LocalDate.of(2020, 1, 8);
 * String username="pika"; User user1 = new User(1, name, mobile, role, gender,
 * about, password,DOB,email,username); when(userController.updateuser((long) 1,
 * user1)).thenReturn(user);
 * 
 * assertThat(user.getFullName()).isEqualTo(name);
 * assertThat(user.getMobilenumber()).isEqualTo(mobile);
 * assertThat(user.getGender()).isEqualTo(gender);
 * assertThat(user.getEmailId()).isEqualTo(email);
 * assertThat(user.getRole()).isEqualTo(role);
 * assertThat(user.getAbout()).isEqualTo(about);
 * assertThat(user.getPassword()).isEqualTo(password);
 * assertThat(user.getDateOfBirth()).isEqualTo(DOB);
 * assertThat(user.getUsername()).isEqualTo(username); }
 * 
 * @Test // testcase to delete user according to given userId void
 * deleteUserTest() { Long user = (long) 1; userController.deleteuser(user);
 * verify(userRepository, times(1)).deleteById(user); }
 * 
 * @Test // test case for delete void deleteuserTest1() { User user = new
 * User(1, "aditi", "9423020355", "user", "female", "xyz","abc123",
 * LocalDate.of(2020, 1, 8), "aditi@gmail.com","pika");
 * when(userRepository.getById((long) 1)).thenReturn(user);
 * 
 * userController.deleteuser((long) 1);
 * 
 * verify(userRepository, times(1)).deleteById((long) 1);
 * 
 * } }
 */