package presentation.Userui;

import init.Client;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Miscellaneous.Authorities;
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
import presentation.mainui.WelcomePanel;

public class MainPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserblService user;
	private final int widthOfUp = 1000;
	private final int heightOfUp = 50;
	private static JButton[] buttontoshow = new JButton[30];
	private static String[] iconAddress = new String[30];
	private final static int width = 64;
	private final static int height = 70;
	private static int buttonClicked = -1;
	public MainPanel(UserblService user){
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
		
		final int PADDING_LEFT = 50;

		PictureLabel bg = new PictureLabel("src/main/java/image/FuncBG.png");
		bg.setBounds(0, 0, 1024, 768);

		final JButton changePassword = new JButton();
		changePassword.setBounds(790, 100, 80, 50);
		setIcon("src/main/java/image/changePassword_1.png",changePassword);
		changePassword.setBorder(null);
		changePassword.setFocusPainted(false);
		changePassword.setContentAreaFilled(false);
		changePassword.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				Client.frame.setEnabled(false);
				JFrame cp = new CPFrame(user);
				cp.setVisible(true);
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				changePassword.setBounds(785, 95, 90, 60);
				setIcon("src/main/java/image/changePassword_1.png",changePassword);
			}
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				changePassword.setBounds(790, 100, 80, 50);
				setIcon("src/main/java/image/changePassword_1.png",changePassword);
			}
			
		});
		
		final JButton exitButton = new JButton();
		exitButton.setBounds(880, 100, 80, 50);
		setIcon("src/main/java/image/exit_1.png",exitButton);
		exitButton.setBorder(null);
		exitButton.setFocusPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				MainPanel.this.setVisible(false);	
				Client.frame.remove(MainPanel.this);
				Client.frame.add(new WelcomePanel());
				Client.frame.repaint();
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				exitButton.setBounds(875, 95, 90, 60);
				setIcon("src/main/java/image/exit_1.png",exitButton);
			}
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				exitButton.setBounds(880, 100, 80, 50);
				setIcon("src/main/java/image/exit_1.png",exitButton);
			}			
		});
		//容器
		final JPanel cardPanel = new JPanel();
		cardPanel.setBounds(50, 156, 906, 552);
		
		//卡片对象
		final CardLayout card = new CardLayout();
		cardPanel.setLayout(card);
		cardPanel.setOpaque(false);
		JPanel buttons = new JPanel();
		buttons.setBounds(PADDING_LEFT, 2*heightOfUp-25, 720, height+10);
		buttons.setBorder(null);
		buttons.setOpaque(false);
		buttons.setLayout(null);
		
		cardPanel.setLayout(card);
		int i = 0;
		
		
		
		JButton button;
		JPanel init = new  JPanel();	
		init.setOpaque(false);
		cardPanel.add(init, "0");

		if (user.hasTheAuthority(Authorities.寄件单)) {	
			JPanel send = new  SendPanel();			
			cardPanel.add(send, "1");				
			button = new InitButton(i,"src/main/java/image/send_unselected.png");		
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/send_unselected.png";
			button.addMouseListener(new MouseListener(){

				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/send_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "1");	
					
				
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/send_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/send_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}		
		if (user.hasTheAuthority(Authorities.收件单)) {
			JPanel receive = new ReceivePanel(user);			
			cardPanel.add(receive, "2");		
			button = new InitButton(i,"src/main/java/image/receive_unselected.png");		
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/receive_unselected.png";
			button.addMouseListener(new MouseListener(){
			
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/receive_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "2");	
					
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/receive_unselected.png",((JButton)e.getSource()));	
					
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/receive_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.装车单)){
			JPanel loading = new LoadingPanel(user);			
			cardPanel.add(loading, "3");			
			button = new InitButton(i,"src/main/java/image/loading_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/loading_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/loading_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "3");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/loading_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/loading_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.到达单)) {
			JPanel arrival = new ArrivalPanel();
			cardPanel.add(arrival, "4");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/arrival_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/arrival_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/arrival_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "4");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/arrival_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/arrival_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.派件单)) {
			JPanel deliver = new DeliverPanel();
			cardPanel.add(deliver, "5");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/deliver_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/deliver_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/deliver_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "5");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/deliver_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/deliver_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.收款单)) {
			JPanel voucher = new VoucherPanel();
			cardPanel.add(voucher, "6");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/voucher_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/voucher_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/voucher_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "6");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/voucher_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/voucher_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.车辆信息)) {
			JPanel car = new CarPanel();
			cardPanel.add(car, "7");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/car_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/car_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/car_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "7");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/car_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/car_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.司机信息)) {
			JPanel driver = new DriverPanel();
			cardPanel.add(driver, "8");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/driver_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/driver_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/driver_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "8");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/driver_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/driver_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.中转单)) {
			JPanel transfer = new TransferPanel();
			cardPanel.add(transfer, "9");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/transfer_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/transfer_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/transfer_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "9");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/transfer_unselected.png",((JButton)e.getSource()));					
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/transfer_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.入库单)) {
			JPanel storageIn = new StorageInPanel(user);
			cardPanel.add(storageIn, "10");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/storageIn_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/storageIn_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/storageIn_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "10");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/storageIn_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/storageIn_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.出库单)) {
			JPanel storageOut = new StorageOutPanel(user);
			cardPanel.add(storageOut, "11");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/storageOut_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/storageOut_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/storageOut_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "11");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/storageOut_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/storageOut_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.库存查看)) {
			JPanel check = new CheckPanel();
			cardPanel.add(check, "12");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/check_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/check_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/check_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "12");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/check_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/check_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.库存盘点)) {
			JPanel stocking =  new StockingPanel();
			cardPanel.add(stocking, "13");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/stocking_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/stocking_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/stocking_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "13");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/stocking_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/stocking_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;			
		}
		if (user.hasTheAuthority(Authorities.分区管理)) {
			JPanel division = new DivisionPanel();
			cardPanel.add(division, "14");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/division_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/division_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/division_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "14");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/division_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/division_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.账户管理)) {
			JPanel account = new AccountPanel();
			cardPanel.add(account, "15");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/account_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/account_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/account_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "15");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/account_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/account_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}		
		if (user.hasTheAuthority(Authorities.审批单据)) {
			JPanel approval = new ApprovalPanel();
			cardPanel.add(approval, "16");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/approval_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/approval_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/approval_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "16");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/approval_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/approval_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.人员机构)) {
			JPanel organization = new OrganizationPanel();
			cardPanel.add(organization, "17");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/organization_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/organization_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/organization_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "17");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/organization_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/organization_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.收款单查询)) {
			JPanel voucherSearch  = new VoucherSearchPanel();
			cardPanel.add(voucherSearch, "18");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/voucherSearch_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/voucherSearch_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/voucherSearch_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "18");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/voucherSearch_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/voucherSearch_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.付款单)) {
			JPanel payment = new PaymentPanel(user);
			cardPanel.add(payment, "19");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/payment_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/payment_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/payment_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "19");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/payment_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/payment_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.成本收益)) {
			JPanel cost = new CostPanel(user);
			cardPanel.add(cost, "20");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/cost_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/cost_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/cost_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "20");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/cost_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/cost_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.经营情况)) {
			JPanel sales = new SalesPanel(user);
			cardPanel.add(sales, "21");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/sales_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/sales_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/sales_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "21");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/sales_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/sales_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.期初建账)) {
			JPanel bill = new BillPanel();
			cardPanel.add(bill, "22");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/bill_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/bill_unselecteds.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/bill_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "22");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/bill_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/bill_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.薪水策略)) {
			JPanel salaryStrategy = new SalaryStrategyPanel();
			cardPanel.add(salaryStrategy, "23");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/salaryStrategy_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/salaryStrategy_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/salaryStrategy_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "23");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/salaryStrategy_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/salaryStrategy_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.价格策略)) {
			JPanel price = new PricePanel();
			cardPanel.add(price, "24");			
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/price_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/price_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/price_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "24");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/price_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/price_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.用户管理)) {
			JPanel userManager = new UserManagerPanel(i);
			cardPanel.add(userManager, "25");		
			button = new JButton();
			button = new InitButton(i,"src/main/java/image/userManager_unselected.png");		
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/userManager_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/userManager_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "25");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/userManager_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/userManager_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.部门管理)) {
			JPanel apartmentManager = new ApartmentManagerPanel(i);
			cardPanel.add(apartmentManager, "26");	
			button = new InitButton(i,"src/main/java/image/apartmentManager_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/apartmentManager_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/apartmentManager_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "26");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/apartmentManager_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/apartmentManager_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.权限管理)){
			JPanel authoritiesSetting = new AuthoritiesSettingPanel(i);
			cardPanel.add(authoritiesSetting, "27");	
			button = new InitButton(i,"src/main/java/image/authoritiesSetting_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/authoritiesSetting_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/authoritiesSetting_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "27");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/authoritiesSetting_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/authoritiesSetting_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}
		if (user.hasTheAuthority(Authorities.系统日志)){
			JPanel diary = new DiaryPanel();
			cardPanel.add(diary, "28");	
			button = new InitButton(i,"src/main/java/image/diary_unselected.png");			
			buttons.add(button);
			buttontoshow[i]=button;
			iconAddress[i] = "src/main/java/image/diary_unselected.png";
			button.addMouseListener(new MouseListener(){
				
				public void mouseClicked(MouseEvent e) {
					if (buttonClicked == ((InitButton)e.getSource()).getNum()) {
						card.show(cardPanel, "0");
						setIcon(iconAddress[buttonClicked],((JButton)e.getSource()));	
						buttonClicked = -1;	
						return;		
					}
					closeButton(buttonClicked);
					buttonClicked = ((InitButton)e.getSource()).getNum();
					setIcon("src/main/java/image/diary_selected.png",((JButton)e.getSource()));		
					card.show(cardPanel, "28");	
					
				}
				public void mousePressed(MouseEvent e) {}
				public void mouseReleased(MouseEvent e) {}
				public void mouseEntered(MouseEvent e) {	
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()-5, ((JButton)e.getSource()).getY()-5, width+10, height+10);
					setIcon("src/main/java/image/diary_unselected.png",((JButton)e.getSource()));						
				}
				public void mouseExited(MouseEvent e) {
					if(buttonClicked == ((InitButton)e.getSource()).getNum()) return;
					((JButton)e.getSource()).setBounds(((JButton)e.getSource()).getX()+5, ((JButton)e.getSource()).getY()+5, width, height);
					setIcon("src/main/java/image/diary_unselected.png",((JButton)e.getSource()));
				}				
			});
			i++;
		}	
		
	
		
		this.add(cardPanel);
		this.add(buttons);
		this.add(changePassword);
		this.add(exitButton);
		this.add(bg);
		this.add(panel);		
	}
	private void initUp() {
		Color color = Color.BLACK;
		Font font = new Font("幼圆",Font.BOLD,20);
		
		JLabel Titlebg = new JLabel("O一O快递物流系统",JLabel.LEFT);
		Titlebg.setForeground(Color.BLACK);
		Titlebg.setFont(new Font("华文行楷",Font.PLAIN,50));
		Titlebg.setBounds(30, 20, 500, 50);
		
		JLabel welcomeSentence = new JLabel("",JLabel.RIGHT);
		welcomeSentence.setSize(widthOfUp, heightOfUp);
		welcomeSentence.setLocation((1024-this.getWidth())/2,0);
		welcomeSentence.setForeground(color);
		welcomeSentence.setFont(font);
		if (user.getUserSex().equals("男")) welcomeSentence.setText(user.getUserName()+"先生，你好(￣▽￣)ノ");//具体晚上好
		else welcomeSentence.setText(user.getUserName()+"女士，你好(￣▽￣)ノ");
		
		JLabel position = new JLabel("",JLabel.RIGHT);
		position.setSize(widthOfUp, heightOfUp);
		position.setLocation((1024-this.getWidth())/2,welcomeSentence.getHeight());
		position.setForeground(color);
		position.setFont(font);
		position.setText("当前位置："+user.getHallName());
	
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
	public static void closeButton(int buttonNum) {
		if (buttonNum == -1) return;
		JButton button= buttontoshow[buttonNum];
		button.setBounds(button.getX()+5, button.getY()+5, width, height);
		setIcon(iconAddress[buttonNum],button);	
		buttonClicked = -1;
		
	}
	
	
}
