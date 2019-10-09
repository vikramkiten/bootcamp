package com.verizon;

import com.verizon.app.Application;
import com.verizon.controller.EmployeeController;
import com.verizon.entities.Employee;
import com.verizon.repositories.EmployeeDao;
import com.verizon.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeController.class,secure = false)
@ContextConfiguration(classes=Application.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private EmployeeDao employeeDao;

    Employee mockEmployee = new Employee("2633375","Bezawada","Vikram","kitesen98@gmail.com","9876543210","MTS-1");
    String exampleEmployeeJson = "{\"employeeId\":\"2633375\",\"firstName\":\"Bezawada\".\"lastName\":\"Vikram\",\"email\":\"kitesen98@gmail.com\",\"phone\":\"9876543210\",\"designation\":\"MTS-1\"}";

//    @Test
//    public void addEmployee() throws Exception
//    {
//        System.out.println("Starting Tests");
//        String str="Employee Added Successfully";
//        Employee mockEmployee = new Employee("2633375","Bezawada","Vikram","kitesen98@gmail.com","9876543210","MTS-1");
//        Mockito.when(employeeService.addEmployee(Mockito.any(Employee.class))).thenReturn(str);
//        RequestBuilder requestBuilder= MockMvcRequestBuilders.post("/employees/")
//                                                                 .accept(MediaType.TEXT_PLAIN_VALUE).
//                        content(exampleEmployeeJson).
//                        contentType(MediaType.APPLICATION_JSON);
//        MvcResult mvcResult=mockMvc.perform(requestBuilder).andReturn();
//        System.out.println(mvcResult);
//        MockHttpServletResponse response = mvcResult.getResponse();
//        System.out.println("This is the response"+response.getContentType());
//        assertEquals(str, response);
//
//    }
//    @Before
//    @Test
//    public  void getAllEmployees() throws  Exception
//    {
//        Employee mockEmployee = new Employee("2633375","Bezawada","Vikram","kitesen98@gmail.com","9876543210","MTS-1");
//        Employee mockEmployee2 = new Employee("2633376","Bezawada","Vikram","kitesen98@gmail.com","9876543210","MTS-1");
//        List<Employee> list=new ArrayList<Employee>() ;
//        list.add(mockEmployee);
//        list.add(mockEmployee2);
//        when(employeeService.getAllEmployees()).thenReturn(list);
//        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/employees/").accept(MediaType.ALL)).andReturn();
//        System.out.println(mvcResult.getResponse().getContentAsString());
//        boolean one=mvcResult.getResponse().getContentAsString().contains(mockEmployee.getEmployeeId());
//        boolean two=mvcResult.getResponse().getContentAsString().contains(mockEmployee2.getEmployeeId());
//              assertEquals(true,one);
//        assertEquals(true,two);
//    }

//
//    @Before
    @Test
    public void addEmployee() throws Exception
    {
        Employee mockEmployee = new Employee("2633375","Bezawada","Vikram","kitesen98@gmail.com","9876543210","MTS-1");
//        Gson gson=new Gson();
//        String json = gson.toJson(mockEmployee);
//          String j=gson.toJson(mockEmployee);
        String json1="{\"employeeId\":\"2633375\",\"firstName\":\"Bezawada\",\"lastName\":\"Vikram\",\"email\":\"kitesen98@gmail.com\",\"phone\":\"9876543210\",\"designation\":\"MTS-1\"}";

//        getAsJsonObject("accounts").remove("email");
//        System.out.println(json1);
        when(employeeService.addEmployee(any(Employee.class))).thenReturn("true");
        MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post("/employees/").
                accept(MediaType.TEXT_PLAIN)
                .content(json1)
              .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals("true",mvcResult.getResponse().getContentAsString());
    }

//    @Test
//    public void removeEmployee() throws Exception
//    {
//        System.out.println("Executing Remove  Employee!");
//        MvcResult mvcResult3=mockMvc.perform(MockMvcRequestBuilders.delete("/employees/1").
//                accept(MediaType.ALL))
//                .andReturn();
//        System.out.println(mvcResult3.getResponse().getContentAsString()+"Remove Employee Test case passed");
//    }
//   @After
//    @Test
//    public void getEmployee() throws Exception
//    {
//        Employee mockEmployee = new Employee("2633375","Bezawada","Vikram","kitesen98@gmail.com","9876543210","MTS-1");
//        List<Employee> emp=new ArrayList<Employee>();
//        when(employeeService.getEmployee(any(Integer.class))).thenReturn("");
//
//        System.out.println("Executing Get Employee!");
//        MvcResult mvcResult2=mockMvc.perform(MockMvcRequestBuilders.get("/employees/1").
//                accept(MediaType.ALL))
//                .andReturn();
//        System.out.println(mvcResult2.getResponse().getContentAsString()+"Get Employee Test case passed");
//    }
}

//import com.verizon.app.Application;
//import com.verizon.controller.EmployeeController;
//import com.verizon.entities.Employee;
//import com.verizon.repositories.EmployeeDao;
//import com.verizon.services.EmployeeService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = EmployeeController.class,secure = false)
//@ContextConfiguration(classes=Application.class)
//public class EmployeeControllerTest
//{
//
//    @InjectMocks
//   EmployeeController employeeController;
//
//    @Mock
//    EmployeeService employeeService;
//
//    @Mock
//    EmployeeDao employeeDao;
//
//    @Test
//    public void testAddEmployee()
//    {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        when(employeeService.addEmployee(any(Employee.class))).thenReturn("Employee added Successfully!");
//
//        Employee employee = new Employee("2633375", "Vikram", "Bezawada",  "Kitensen98@gmail.com", "9876543210", "MTS-1");
//        ResponseEntity<String> responseEntity = employeeController.addEmployee(employee);
//
//        assertEquals("200",responseEntity.getStatusCodeValue());
////        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
//    }
//
//
//}
