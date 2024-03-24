var massratan=prompt("enter the ratan mass")
var massanu =prompt("enter the anu mass")
var heightratan=prompt("enter the ratan height")
var heightanu=prompt("enter the anu height")
var BMIratan;
var BMIanu;
var BMIhigher;
 BMIratan=massratan/(heightratan*heightratan)
 BMIanu=massanu/(heightanu*heightanu)
 document.write("ratan BMI="+BMIratan)
 document.write("anu BMI"+BMIanu)
 if(BMIratan>BMIanu)
 {
	 BMIhigher=document.write("ratan BMI is Higher")
 }
 else{
	 BMIhigher=document.write("anu BMI is higher")
 }
 
 