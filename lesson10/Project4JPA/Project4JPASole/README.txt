
MAIN EXAMPLES:

http://localhost:8091/Project4JPA/



::: OneToOne- Bi - save "Parent" ::::

Demo cascade on one-to-one to child

ALSO   Exercise detached object

/Simulate detached object for phone 
When we save phone:
   	Phone phone = phoneService.save(product.getHotLine()); 
This results in a DIFFERENT phone from one associated with the product . 
this [saved ] one is detached
the one in product is transient
As a result this will cause an update instead of an insert:
   	phone.setNumber(1);
  	product.setHotLine(phone);   
 
 
 
::: OneToOne- Bi - save "Child" ::::

Saves phone
Demo cascade on one-to-one to product



::: OneToManyUniJoinColumn :::

ALSO exercises how to initialize a collection that is Lazy

AFTER we save:
		   employee =  employeeService.save(employee);
 
 If we get a new copy of the employee and   TRY to reference the phones 
 we will get an exception:
		   employee = employeeService.get(employee.getId());
So we need to get the employee & the phones in the same transaction [special getPhones method]:
		     employee = employeeService.getPhones(employee.getId());


::: OneToMany Uni - JoinTable :::

ALSO exercises MANY-TO_MANY
See code


