package prob5;

public class Account {
	
	private String accountNo;
	private int balance = 0;;
	
	public Account(String accountNo)
	{
		this.accountNo = accountNo;
		System.out.println(this.accountNo + " 계좌가 개설되었습니다.");
	}
	
	public String getAccountNo()
	{
		return accountNo;
	}
	
	public int getBalance()
	{
		return balance;
	}
	
	public void setBalance()
	{
		this.balance += balance;
	}
	
	public void save(int save)
	{
		balance += save;
		System.out.println(this.accountNo + " 계좌에 " + save + "만원이 입금되었습니다.");
	}
	
	public void deposit(int save)
	{
		balance -= save;
		System.out.println(this.accountNo + " 계좌에 " + save + "만원이 출금되었습니다.");
	}
}