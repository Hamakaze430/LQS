package presentation.Userui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import businessLogicService.UserblService.UserblService;
import presentation.Approvalui.ApprovalPanel;
import presentation.BankAccountui.AccountPanel;
import presentation.BillManagementui.BillPanel;
import presentation.CarAndDriverui.CarPanel;
import presentation.CarAndDriverui.DriverPanel;
import presentation.CostBenefitui.CostPanel;
import presentation.Receiptsui.ArrivalPanel;
import presentation.Receiptsui.DeliverPanel;
import presentation.Receiptsui.LoadingPanel;
import presentation.Receiptsui.PaymentPanel;
import presentation.Receiptsui.ReceivePanel;
import presentation.Receiptsui.SendPanel;
import presentation.Receiptsui.StorageInPanel;
import presentation.Receiptsui.StorageOutPanel;
import presentation.Receiptsui.TransferPanel;
import presentation.Receiptsui.VoucherPanel;
import presentation.Salesui.SalesPanel;
import presentation.Strategyui.PricePanel;
import presentation.Strategyui.SalaryStrategyPanel;
import presentation.VoucherSearchui.VoucherSearchPanel;
import presentation.WareHouseui.CheckPanel;
import presentation.WareHouseui.DivisionPanel;
import presentation.WareHouseui.StockingPanel;
import presentation.mainui.DiaryPanel;
import presentation.mainui.PictureLabel;
import vo.Authorities;
import vo.UserBaseVO;

public class AfterLoginPanel extends JPanel {
	private UserblService user;
	private final int width = 1000;
	private final int height = 50;
	
	public AfterLoginPanel(UserblService user){
		this.user = user;
		this.setSize(1024,768);
		this.setLayout(null);
		initUp();
		initFunction();
	}
	private void initFunction() {
		// TODO Auto-generated method stub
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1024, 768);
		
		final int PADDING_LEFT = 30;
		final int PADDIGN_UP = 20;
		final int PADDING_DOWN = 100;
		
		PictureLabel bg = new PictureLabel("src/main/java/image/FuncBG.png");
		bg.setBounds(0, 0, 1024, 768);
		UIManager.put("TabbedPane.contentOpaque", false);
		//UIManager.put("TabbedPane.tabAreaBackground",new Color(255,255,255));
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setBounds(PADDING_LEFT, PADDIGN_UP+2*height, width-2*PADDING_LEFT, panel.getHeight()-2*height-PADDING_DOWN-PADDIGN_UP);
		//tab.setBorder(new MatteBorder(0, 0, 0, 0, Color.WHITE));
		//tab.setBackground(new Color(255,255,255,0));
		
	//	JPanel info = new JPanel();
		
		if (user.hasTheAuthority(Authorities.寄件单)) {	
			JPanel send = new SendPanel();
			tab.add(Authorities.寄件单.name(), send);
		}
		if (user.hasTheAuthority(Authorities.收件单)) {
			JPanel receive = new ReceivePanel(user);
			tab.add(Authorities.收件单.name(), receive);
		}
		if (user.hasTheAuthority(Authorities.装车单)){
			JPanel loading = new LoadingPanel(user);
			tab.add(Authorities.装车单.name(), loading);
		}
		if (user.hasTheAuthority(Authorities.到达单)) {
			JPanel arrval = new ArrivalPanel();
			tab.add(Authorities.到达单.name(), arrval);
		}
		if (user.hasTheAuthority(Authorities.派件单)) {
			JPanel deliver = new DeliverPanel();
			tab.add(Authorities.派件单.name(), deliver);
		}
		if (user.hasTheAuthority(Authorities.收款单)) {
			JPanel voucher = new VoucherPanel();
			tab.add(Authorities.收款单.name(), voucher);
		}
		if (user.hasTheAuthority(Authorities.车辆信息)) {
			JPanel car = new CarPanel();
			tab.add(Authorities.车辆信息.name(), car);
		}
		if (user.hasTheAuthority(Authorities.司机信息)) {
			JPanel driver = new DriverPanel();
			tab.add(Authorities.司机信息.name(), driver);
		}
		if (user.hasTheAuthority(Authorities.中转单)) {
			JPanel transfer = new TransferPanel();
			tab.add(Authorities.中转单.name(),transfer);
		}
		if (user.hasTheAuthority(Authorities.入库单)) {
			JPanel storageIn = new StorageInPanel();
			tab.add(Authorities.入库单.name(), storageIn);
		}
		if (user.hasTheAuthority(Authorities.出库单)) {
			JPanel storageOut = new StorageOutPanel();
			tab.add(Authorities.出库单.name(), storageOut);
		}
		if (user.hasTheAuthority(Authorities.库存查看)) {
			JPanel check = new CheckPanel();
			tab.add(Authorities.库存查看.name(), check);
		}
		if (user.hasTheAuthority(Authorities.库存盘点)) {
			JPanel stocking =  new StockingPanel();
			tab.add(Authorities.库存盘点.name(), stocking);
			
		}
		if (user.hasTheAuthority(Authorities.分区管理)) {
			JPanel division = new DivisionPanel();
			tab.add(Authorities.分区管理.name(), division);
		}
		if (user.hasTheAuthority(Authorities.账户管理)) {
			JPanel account = new AccountPanel();
			tab.add(Authorities.账户管理.name(), account);
		}
		if (user.hasTheAuthority(Authorities.审批单据)) {
			JPanel approval = new ApprovalPanel();
			tab.add(Authorities.审批单据.name(), approval);
		}
		if (user.hasTheAuthority(Authorities.人员机构)) {
			JPanel organization = new OrganizationPanel();
			tab.add(Authorities.人员机构.name(), organization);
		}
		if (user.hasTheAuthority(Authorities.收款单查询)) {
			JPanel voucherSearch  = new VoucherSearchPanel();
			tab.add(Authorities.收款单查询.name(), voucherSearch);
		}
		if (user.hasTheAuthority(Authorities.付款单)) {
			JPanel payment = new PaymentPanel();
			tab.add(Authorities.付款单.name(), payment);
		}
		if (user.hasTheAuthority(Authorities.成本收益)) {
			JPanel cost = new CostPanel();
			tab.add(Authorities.成本收益.name(), cost);
		}
		if (user.hasTheAuthority(Authorities.经营情况)) {
			JPanel sales = new SalesPanel();
			tab.add(Authorities.经营情况.name(), sales);
		}
		if (user.hasTheAuthority(Authorities.期初建账)) {
			JPanel bill = new BillPanel();
			tab.add(Authorities.期初建账.name(), bill);
		}
		if (user.hasTheAuthority(Authorities.薪水策略)) {
			JPanel salaryStrategy = new SalaryStrategyPanel();
			tab.add(Authorities.薪水策略.name(), salaryStrategy);
		}
		if (user.hasTheAuthority(Authorities.价格策略)) {
			JPanel price = new PricePanel();
			tab.add(Authorities.价格策略.name(), price);
		}
		if (user.hasTheAuthority(Authorities.用户管理)) {
			JPanel userManager = new UserManagerPanel();
			tab.add(Authorities.用户管理.name(), userManager);
		}
		if (user.hasTheAuthority(Authorities.部门管理)) {
			JPanel apartmentManager = new ApartmentManagerPanel();
			tab.add(Authorities.部门管理.name(), apartmentManager);
		}
		if (user.hasTheAuthority(Authorities.权限管理)){
			JPanel authoritiesSetting = new AuthoritiesSettingPanel();
			tab.add(Authorities.权限管理.name(), authoritiesSetting);
		}
		if (user.hasTheAuthority(Authorities.系统日志)){
			JPanel diary = new DiaryPanel();
			tab.add(Authorities.系统日志.name(), diary);
		}
		
	//	tab.addTab("消息",info);
		
		panel.add(tab);
		
		
		this.add(panel);
	}
	private void initUp() {
		
		
		Color color = Color.BLACK;
		Font font = new Font("幼圆",Font.BOLD,20);
		
//		JPanel upPanel = new JPanel();
//		upPanel.setBounds(0, 0, 1024, height*2);
//		upPanel.setLayout(null);
//		
		
		JLabel Titlebg = new JLabel("O一O快递物流系统",JLabel.LEFT);
		Titlebg.setForeground(Color.BLACK);
		Titlebg.setFont(new Font("华文行楷",Font.PLAIN,50));
		Titlebg.setBounds(30, 30, 500, 50);
		
		JLabel welcomeSentence = new JLabel("",JLabel.RIGHT);
		welcomeSentence.setSize(width, height);
		welcomeSentence.setLocation((1024-this.getWidth())/2,0);
		welcomeSentence.setForeground(color);
		welcomeSentence.setFont(font);
		if (user.getSex() == 0) welcomeSentence.setText(user.getName()+"先生，你好(￣▽￣)ノ");//具体晚上好
		else welcomeSentence.setText(user.getName()+"女士，你好(￣▽￣)ノ");
		

		JLabel position = new JLabel("",JLabel.RIGHT);
		position.setSize(width, height);
		position.setLocation((1024-this.getWidth())/2,welcomeSentence.getHeight());
		position.setForeground(color);
		position.setFont(font);
		position.setText("当前位置："+user.getHall().getName());
//		
//		upPanel.add(Titlebg);
//		upPanel.add(welcomeSentence);
//		upPanel.add(position);
//		
//		
		this.add(Titlebg);
		this.add(welcomeSentence);
		this.add(position);
		
	}
	public static void setIcon(String file,JButton iconButton){
		ImageIcon icon = new ImageIcon(file);
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(), iconButton.getHeight(), icon.getImage().SCALE_DEFAULT);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
		
		
	}
	
	
}
