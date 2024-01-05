import java.util.*;

class Marksheet
{
	Scanner sc=new Scanner(System.in);

	void login(String Id)  //login method 
	{
		Marksheet l_Marksheet=new Marksheet();
		int attempt=1;
		if(Id.equals("3abc")||Id.equals("6abc")||Id.equals("8abc")) // predefined user ids
		{
			System.out.println("enter password:");
			String pass=sc.next();
		    l_Marksheet.pass1(pass);
		}
		else
		{
			System.out.println("Invalid userId !!...\nRe-enter userId");
			String Id1=sc.next();
			for(int f=0;f<5;f++)
			{
				attempt++;
				if(attempt==3)
				{
					l_Marksheet.login(Id1);
					break;
				}
				
			}
		}
		
	}
	void pass1(String pass)
	{
		Marksheet p_Marksheet=new Marksheet();
		int p_attempt=1;
		if(pass.equals("3456")||pass.equals("1234")||pass.equals("5678")) // predefined user password
		{
			System.out.println();
		}
		else
		{
			System.out.println("Invalid password !!...\nRe-enter password");
			String password=sc.next();
			for(int g=0;g<5;g++)
			{
				p_attempt++;
				if(p_attempt==3)
				{
					p_Marksheet.pass1(password);
					break;
				}
				
				
			}
		}
	}
    
	public static void main(String args[])        
	{
		Marksheet m_Marksheet=new Marksheet();
		int n,sem;
		double total=0,per,credit=0,SP=0,cr=0;
		String name,SPI="0",rollno;
		Scanner sc=new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("....................Marksheet Generation System....................");
		System.out.println();
		System.out.println();
		System.out.println("Enter UserId:");
		String Id=sc.next();
		m_Marksheet.login(Id);
		System.out.println("....................WELCOME TO MARKSHEET GENERATION SySTEM....................");
		
		//taking input
		
		System.out.println("Enter Semester:");
		sem=sc.nextInt();
		System.out.println("Enter The Student Roll No:");
		rollno=sc.next();
		System.out.println("Enter The Student Name:");
		sc.nextLine();
        name=sc.nextLine();
		name=name.toUpperCase();
		int attempt=name.length();
		System.out.println();
		System.out.println("Enter No. Of Subject:");
		n=sc.nextInt();
		String marks[]=new String[n];
		String sub[]=new String[n];
		double a[]=new double[n];
		System.out.println();
		System.out.println("Enter Marks out of 100:"+"\nFor Absent Students write :"+"AB");
		System.out.println();
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Sub"+(i+1)+"=");
			sc.nextLine();
			sub[i]=sc.nextLine();
			sub[i]=sub[i].toUpperCase();
			if(sub[i].equalsIgnoreCase("Maths"))     //FOR PERTICULAR SUBJECT
			{
				credit=6;
			}
			else if(sub[i].equalsIgnoreCase("Physics"))
			{
				credit=4;
			}
			else if(sub[i].equalsIgnoreCase("Java"))
			{
				credit=6;
			}
			else if(sub[i].equalsIgnoreCase("S.E")||sub[i].equalsIgnoreCase("Software Engineering"))
			{
				credit=4;
            }
			else if(sub[i].equalsIgnoreCase("E.S")||sub[i].equalsIgnoreCase("Environment Science"))
			{
				credit=0;
			}
			else if(sub[i].equalsIgnoreCase("I.O.T")||sub[i].equalsIgnoreCase("CWS"))
			{
				credit=2;
			}
			else
			{
				credit=0;
			}
			System.out.println("Enter Marks"+(i+1)+"=");
			marks[i]=sc.next();
			if(marks[i].equalsIgnoreCase("AB")|| (Integer.parseInt(marks[i])>=0 && Integer.parseInt(marks[i])<=100 ))
			{
				
				for(int l=0;l<n;l++)
				{
					if(marks[i].equalsIgnoreCase("AB"))
					{
						marks[i]="AB";
						a[l]=0;
					}
					else
					{
					
						a[l]=Integer.parseInt(marks[i]);
					}
				}
				total=total+a[i];
			}
			else
			{
				while(true)
				{
					System.out.println("Enter Valid Marks");
					marks[i]=sc.next();
					if(Integer.parseInt(marks[i])>0)
					{
						break;
					}
				}
				
			}
			SP=SP+(a[i]*credit);
			cr=cr+credit;
		}
		double s=Double.parseDouble(SPI);
		s=SP/(cr*10);
		SPI=Double.toString(s);


		// for display marksheet
		try {
			
		System.out.println();
		System.out.println("**************************************************");
		System.out.println("                  L.J UNIVERSITy                  ");
		System.out.println("**************************************************");
		System.out.println();
		System.out.println("__________________________________________________");
		System.out.print  ("|STUDENT NAME |"+name);
			
		for(int b=(34-attempt);b>0;b--)
		{
			System.out.print(" ");
		}
		System.out.println("|");
		System.out.println("__________________________________________________");
		if(rollno.length()==1)
		{
			System.out.println("|ROLL NO      |"+rollno+"                                 |");
		}
		else if(rollno.length()==2)
		{
			System.out.println("|ROLL NO      |"+rollno+"                                |");
		}
		else if(rollno.length()==3)
		{
			System.out.println("|ROLL NO      |"+rollno+"                                 |");
		}
		System.out.println("__________________________________________________");
		System.out.println("|SEM          |"+sem+"                                 |");
		System.out.println("__________________________________________________");
		System.out.println("|SUBJECT                       |"+"MARKS            |");
		System.out.println("__________________________________________________");
            
		for(int i=0;i<n;i++)
		{
			System.out.print("|"+sub[i]);
			int y=sub[i].length();
			for(int b=(30-y);b>0;b--)
			{
				System.out.print(" ");
		    }
			System.out.print("|");
			System.out.print(marks[i]);
			int m=marks[i].length();
			for(int b=(17-m);b>0;b--)
			{
				System.out.print(" ");
			} 
			System.out.println("|");
			System.out.println("--------------------------------------------------");
		}
		per=(total*100)/(n*100);
		System.out.println("__________________________________________________");
		System.out.println("|TOTAL MARKS       |"+total+"                        |");
		System.out.println("__________________________________________________");
		String b=Double.toString(per);
		if(b.length()>4)
		{
			System.out.println("|PERCENTAGE        |"+b.charAt(0)+b.charAt(1)+b.charAt(2)+b.charAt(3)+b.charAt(4)+"                        |");
		}
		else
		{
			System.out.println("|PERCENTAGE        |"+per+"                         |");    
		}
		System.out.println("__________________________________________________");
		if(per>80)
		{
			System.out.println("|GRADE             | A                           |");
			System.out.println("__________________________________________________");
		}
		else if(per>=60)
		{
			System.out.println("|GRADE             | B                           |");
			System.out.println("__________________________________________________");
		}
		else if(per>=45)
		{
			System.out.println("|GRADE             | C                           |");
			System.out.println("__________________________________________________");
		}
		else if(per>=35)
		{
			System.out.println("|GRADE             | D                           |");
			System.out.println("__________________________________________________");
		}
		else
		{
			System.out.println("|RESULT            |FAIL                         |");
			System.out.println("__________________________________________________");
		}
		if(SPI.length()>=4)
		{
			System.out.println("|SPI               |"+SPI.charAt(0)+SPI.charAt(1)+SPI.charAt(2)+SPI.charAt(3)+SPI.charAt(4)+"                        |");
        }
		else if(SPI.length()>=2&&SPI.length()<4)
		{
			System.out.println("|SPI               |"+SPI.charAt(0)+SPI.charAt(1)+SPI.charAt(2)+"                          |");
		}
		else
		{
			System.out.println("|SPI               |"+SPI+"                         |");
		}
		System.out.println("__________________________________________________");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

