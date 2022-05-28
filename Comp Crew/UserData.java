package pkg1;

public class UserData 
{
	String name,id,pw;
	static Account[] hashtable=new Account[10];
	
	UserData(int key)
	{
		//empty constructor
	}
	
	
	UserData(int key,String res,String ticket)
	{
		hashtable[key].booking=res;
		hashtable[key].ticket=ticket;
	}
	
	UserData()
	{
		for(int i=0;i<10;i++)
		{
			hashtable[i] = new Account();
		}
		
		hashtable[0] = new Account("admin","admin@google","123",0);
	}
	
	int UserDataStorage(String name, String id, String pw,int key)
	{
		int flag=0;
		
		if(key!=0)
		{
			for(int i=key;i>=0;i--)
			{
				if((hashtable[i].id).equals(id))
				{
					return flag;
				}
			}
		}
		
		hashtable[key] = new Account(name,id,pw,key);
		return flag;//new Registration("Account Created Successfully..!");
	}
	
	int Check(String id,String pw)
	{
		int i=0;
		int key=-1;
		
		while(hashtable[i].key!=-1 && i<10)
		{
			if((hashtable[i].id).equals(id) && (hashtable[i].pw).equals(pw))
				key = hashtable[i].key;
			i++;
		}
		return key;
		
	}
	
	String getbooking(int key)
	{
		return hashtable[key].booking;
	}
	
	String getticket(int key)
	{
		return hashtable[key].ticket;
	}
}

class Account
{
	String name="",id="",pw="",booking="",ticket="";
	int key=-1;
	
	public Account()
	{
		this.name="";
		this.id="";
		this.pw="";
		this.key=-1;
		this.booking="";
		this.ticket="";
	}
	
	public Account(String name, String id, String pw,int key)
	{
		this.name=name;
		this.id=id;
		this.pw=pw;
		this.key=key;
		this.booking="No Bookings";
		this.ticket="";
	}
}