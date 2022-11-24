import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javazoom.jl.player.Player;
class Fake extends JFrame
{
	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 750;
	public static final int MAX_FRAME = 39;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int UP = 3;
	public static final int DOWN = 4;
	public static final int MOVE = 5;
	public static final int KEY_WIDTH = 60;
	public static final int STAGE_WIDTH = 20;
	public static final int COLORMAX = 200;
	public static final int COLORMIN = 55;
	public static final int N_FLYEFFECT = 9;
	public static final int MAX_FEDIS = 75;
	public static final int MAX_SCORE = 999999;
	private Image screenImage;
	private Graphics screenGraphic;

	private int mouseX, mouseY;

	private Image Backpart1 = new ImageIcon("images/backGround/backPart1.png").getImage();
	private Image Backpart2 = new ImageIcon("images/backGround/backPart2.png").getImage();
	private Image Backpart3 = new ImageIcon("images/backGround/Moon.png").getImage();
	private JLabel menuBar = new JLabel(new ImageIcon("images/menuBar.png"));


	private ImageIcon i_CLSB = new ImageIcon("images/CLSB.png");
	private ImageIcon i_CLSBS = new ImageIcon("images/CLSBSelect.png");
	private ImageIcon i_STTB = new ImageIcon("images/startButton.png");
	private ImageIcon i_STTBS = new ImageIcon("images/startButtonSelect.png");
	private ImageIcon i_EXTB = new ImageIcon("images/exitButton.png");
	private ImageIcon i_EXTBS = new ImageIcon("images/exitButtonSelect.png");
	private ImageIcon i_RTYB = new ImageIcon("images/retryButton.png");
	private ImageIcon i_RTYBS = new ImageIcon("images/retryButtonSelect.png");
	private ImageIcon i_MAINB = new ImageIcon("images/mainButton.png");
	private ImageIcon i_MAINBS = new ImageIcon("images/mainButtonSelect.png");
	private ImageIcon i_GVUB = new ImageIcon("images/giveupButton.png");
	private ImageIcon i_GVUBS = new ImageIcon("images/giveupButtonSelect.png");
	private ImageIcon i_LFB = new ImageIcon("images/left.png");
	private ImageIcon i_LFBS = new ImageIcon("images/leftSelect.png");
	private ImageIcon i_RTB = new ImageIcon("images/right.png");
	private ImageIcon i_RTBS = new ImageIcon("images/rightSelect.png");
	private ImageIcon i_NTB = new ImageIcon("images/nextButton.png");
	private ImageIcon i_NTBS = new ImageIcon("images/nextButtonSelect.png");
	private ImageIcon i_PYB = new ImageIcon("images/playButton.png");
	private ImageIcon i_PYBS = new ImageIcon("images/playButtonSelect.png");

	private JButton CLSB = new JButton(i_CLSB);
	private JButton STTB = new JButton(i_STTB);
	private JButton EXTB = new JButton(i_EXTB);
	private JButton RTYB = new JButton(i_RTYB);
	private JButton MAINB = new JButton(i_MAINB);
	private JButton GVUB = new JButton(i_GVUB);
	private JButton LFB = new JButton(i_LFB);
	private JButton RTB = new JButton(i_RTB);
	private JButton SLB = new JButton(i_STTB);
	private JButton NTB = new JButton(i_NTB);
	private JButton PYB = new JButton(i_PYB);
	private Image i_EDP = new ImageIcon("images/endpage.png").getImage();

	private Image i_LKEY = new ImageIcon("images/key/leftKey.png").getImage();
	private Image i_RKEY = new ImageIcon("images/key/rightKey.png").getImage();
	private Image i_UKEY = new ImageIcon("images/key/upKey.png").getImage();
	private Image i_DKEY = new ImageIcon("images/key/downKey.png").getImage();

	private Image i_EFFECT = new ImageIcon("images/key/motionKeyEffect.png").getImage();
	private Image i_SKEY = new ImageIcon("images/key/slideKey.png").getImage();
	private Image i_JKEY = new ImageIcon("images/key/jumpKey.png").getImage();
	private Image i_KKEY = new ImageIcon("images/key/kickKey.png").getImage();
	private Image i_FKEY = new ImageIcon("images/key/flyKey.png").getImage();
	private Image i_SKEY_C = new ImageIcon("images/key/slideKeyCorrect.png").getImage();
	private Image i_JKEY_C = new ImageIcon("images/key/jumpKeyCorrect.png").getImage();
	private Image i_KKEY_C = new ImageIcon("images/key/kickKeyCorrect.png").getImage();
	private Image i_FKEY_C = new ImageIcon("images/key/flyKeyCorrect.png").getImage();
	private Image i_WALL = new ImageIcon("images/wall/wall.png").getImage();

	private Image i_STAGE0 = new ImageIcon("images/stage/stage0.png").getImage();
	private Image i_STAGE0C = new ImageIcon("images/stage/stage0Correct.png").getImage();
	private Image i_STAGE1 = new ImageIcon("images/stage/stage1.png").getImage();
	private Image i_STAGE1C = new ImageIcon("images/stage/stage1Correct.png").getImage();
	private Image i_STAGE2 = new ImageIcon("images/stage/stage2.png").getImage();
	private Image i_STAGE2C = new ImageIcon("images/stage/stage2Correct.png").getImage();

	private Image i_BLOCK0 = new ImageIcon("images/stage/block0.png").getImage();
	private Image i_BLOCK0C = new ImageIcon("images/stage/block0Correct.png").getImage();
	private Image i_BLOCK1 = new ImageIcon("images/stage/block1.png").getImage();
	private Image i_BLOCK1C = new ImageIcon("images/stage/block1Correct.png").getImage();
	private Image i_BLOCK2 = new ImageIcon("images/stage/block2.png").getImage();
	private Image i_BLOCK2C = new ImageIcon("images/stage/block2Correct.png").getImage();

	private double setha = 0;

	private Music BGM = new Music("musics/Various Artists-14-Butter-Fly (Digimon Adventure (디지몬 어드벤처))-128.mp3", true);

	private String motionKind[] = { "walk", "run",  "jump", "slide" , "falldown", "kick" , "fly"};

	private String moveMotion = motionKind[1];
	private String nextMotion = motionKind[1];
	private String crtMotion = motionKind[1];

	private String crtColor = "none";

	private int Frame = -1;
	private int FrameCount = 0;
	private int slideLasting = 0;
	private int kickLasting = 0;
	private int flyLasting = 0;
	private boolean motionChange = false;
	//	private boolean motionChange = true;
	private boolean isFrameIcs = true;

	private boolean input[] = { false, false, false, false};

	private boolean createNotePage = true;
	private boolean note[];
	private int noteEffect[];
	private int N_note = 0;
	private int flyEffectPosY[] = new int[9];
	private int flyEffectDis;

	private boolean isDowning = false;
	private boolean isStageBlank = true;
	private int blankCount = 0;
	private boolean isBlocking = false;
	private boolean isFaint = false;
	private boolean isEndPage = false;
	private boolean isGamePage = false;
	private boolean isMainPage = true;
	private boolean isSelectPage = false;
	private boolean isExplanePage = false;
	private boolean isSlideSucc = false;
	private boolean isFlyable = false;
	private double flySetha;
	private int SCORE = 0;

	private double BposX1 = 0 ;
	private double BposX2 = 0;
	private double BposX3 = SCREEN_WIDTH - 120;

	private int CposY;

	private double nt_spd[] = { 1.5 , 2.5 , 4.0, 7.0};
	private double BG_spd[] = { 1.5 , 2.5 , 4.0, 7.0};

	private int Midx = 0;
	private String ablumArt[] = {
			"images/selectMusicMain.png",
			"images/selectMusic1.png",
			"images/selectMusic2.png"
	};
	private int eidx = 0;
	private String explaneImage[] = {
			"images/explane1.png",
			"images/explane2.png",
	};
	private String BGMList[] = {
			"musics/Various Artists-14-Butter-Fly (Digimon Adventure (디지몬 어드벤처))-128.mp3",
			"musics/Muse - Neutron star collision(inst).mp3",
			"musics/DJ Okawari-05-Flower Dance-128.mp3"
	};
	private String selectList[] = {
			"musics/Various Artists-14-Butter-Fly (Digimon Adventure (디지몬 어드벤처))-128.mp3",
			"musics/Muse-01-Neutron Star Collision (Love Is Forever) (트와일라잇 3_ 이클립스 삽입곡)-128.mp3",
			"musics/DJ Okawari-05-Flower Dance-128.mp3"
	};
	private long musicLength[] = {0,233000,266000};
	private long remainTime = -1;

	private long CRT_TIME;
	private long PAST_TIME;

	private double GameSPD = nt_spd[0];

	public Fake()
	{
		setTitle("Fake");
		setSize(SCREEN_WIDTH ,SCREEN_HEIGHT);
		setResizable(false);	// 크기 변경 해제
		setLocationRelativeTo(null);  //중간위치의 생성
		setUndecorated(true); // 창제거
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0)); //프레임 투명처리
		setLayout(null);

		BGM.start();

		addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				String s = e.getKeyText(e.getKeyCode()); // 키값
				System.out.println(s+"가 on.");
				if (s == "Down")  slideLasting = 0;
				if(motionChange)
				{
					switch(s)
					{
						case "Left":		nextMotion = motionKind[5];	break;
						case "Right":		nextMotion = motionKind[6];		break;
						case "Up":		nextMotion = motionKind[2];	break;
						case "Down":	nextMotion = motionKind[3]; ;break;
					}
				}
				switch(s)
				{
					case "Left":		input[0] = true; input[1] = false ; input[2] = false; input[3] = false;	break;
					case "Right":		input[0] = false; input[1] = true ; input[2] = false; input[3] = false;	break;
					case "Up":			input[0] = false; input[1] = false ; input[2] = true; input[3] = false;	break;
					case "Down":		input[0] = false; input[1] = false ; input[2] = false; input[3] = true;;break;
				}
			}
			public void keyReleased(KeyEvent e)
			{
				String s = e.getKeyText(e.getKeyCode()); // 키값
				System.out.println(s+"가 off.");
				switch(s)
				{
					case "Left":		input[0] = false; break;
					case "Right":		input[1] = false; break;
					case "Up":			input[2] = false; break;
					case "Down":		input[3] = false; break;
				}
			}
		});

		//창 닫기 버튼
		CLSB.setBounds(1250,0,30,30);
		CLSB.setBorderPainted(false);
		CLSB.setContentAreaFilled(false);
		CLSB.setFocusPainted(false);
		CLSB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				CLSB.setIcon(i_CLSBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				CLSB.setIcon(i_CLSB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				System.exit(1);
			}
		});
		add(CLSB);

		//메인 시작 버튼
		STTB.setBounds(900,600,350,100);
		STTB.setBorderPainted(false);
		STTB.setContentAreaFilled(false);
		STTB.setFocusPainted(false);
		STTB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				STTB.setIcon(i_STTBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				STTB.setIcon(i_STTB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				selectPage();
			}
		});
		add(STTB);
		STTB.setVisible(true);

		//선택창 버튼
		LFB.setBounds(200,340,100,100);
		LFB.setBorderPainted(false);
		LFB.setContentAreaFilled(false);
		LFB.setFocusPainted(false);
		LFB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				LFB.setIcon(i_LFBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				LFB.setIcon(i_LFB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				SLB.setVisible(true);
				Midx--;
				if (Midx <= 0)
					Midx =  BGMList.length - 1;
				BGM.close();
				BGM = new Music(selectList[Midx], true);
				BGM.start();
			}
		});
		add(LFB);
		LFB.setVisible(false);

		RTB.setBounds(980,340,100,100);
		RTB.setBorderPainted(false);
		RTB.setContentAreaFilled(false);
		RTB.setFocusPainted(false);
		RTB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				RTB.setIcon(i_RTBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				RTB.setIcon(i_RTB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				SLB.setVisible(true);
				Midx++;
				if (Midx >= BGMList.length)
					Midx =  1;
				BGM.close();
				BGM = new Music(selectList[Midx], true);
				BGM.start();
			}
		});
		add(RTB);
		RTB.setVisible(false);

		SLB.setBounds(465,600,350,100);
		SLB.setBorderPainted(false);
		SLB.setContentAreaFilled(false);
		SLB.setFocusPainted(false);
		SLB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				SLB.setIcon(i_STTBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				SLB.setIcon(i_STTB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				if (Midx != 0)
					explanePage();
			}
		});
		add(SLB);
		SLB.setVisible(false);

		//설명창 버튼
		NTB.setBounds(540,610,200,70);
		NTB.setBorderPainted(false);
		NTB.setContentAreaFilled(false);
		NTB.setFocusPainted(false);
		NTB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				NTB.setIcon(i_NTBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				NTB.setIcon(i_NTB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				NTB.setVisible(false);
				PYB.setVisible(true);
				eidx++;
			}
		});
		add(NTB);
		NTB.setVisible(false);

		PYB.setBounds(540,610,200,70);
		PYB.setBorderPainted(false);
		PYB.setContentAreaFilled(false);
		PYB.setFocusPainted(false);
		PYB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				PYB.setIcon(i_PYBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				PYB.setIcon(i_PYB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				gameStart();
			}
		});
		add(PYB);
		PYB.setVisible(false);

		//게임 화면 버튼
		GVUB.setBounds(1030,30,250,70);
		GVUB.setBorderPainted(false);
		GVUB.setContentAreaFilled(false);
		GVUB.setFocusPainted(false);
		GVUB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				GVUB.setIcon(i_GVUBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				GVUB.setIcon(i_GVUB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				MainPage();
			}
		});
		add(GVUB);
		GVUB.setVisible(false);

		//엔드 페이지 버튼들
		//재도전 버튼
		RTYB.setBounds(85, 510 ,350,100);
		RTYB.setBorderPainted(false);
		RTYB.setContentAreaFilled(false);
		RTYB.setFocusPainted(false);
		RTYB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				RTYB.setIcon(i_RTYBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				RTYB.setIcon(i_RTYB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				retry();
			}
		});
		add(RTYB);
		RTYB.setVisible(false);

		//게임 끝나고 메인 버튼
		MAINB.setBounds(465, 510 ,350,100);
		MAINB.setBorderPainted(false);
		MAINB.setContentAreaFilled(false);
		MAINB.setFocusPainted(false);
		MAINB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				MAINB.setIcon(i_MAINBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				MAINB.setIcon(i_MAINB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				MainPage();
			}
		});
		add(MAINB);
		MAINB.setVisible(false);

		//게임 종료 버튼
		EXTB.setBounds(845, 510 ,350,100);
		EXTB.setBorderPainted(false);
		EXTB.setContentAreaFilled(false);
		EXTB.setFocusPainted(false);
		EXTB.addMouseListener(new MouseAdapter() {
			@Override	//마우스 올렷을때
			public void mouseEntered(MouseEvent e) {
				EXTB.setIcon(i_EXTBS);
			}
			@Override	//마우스 벗어났을때
			public void mouseExited(MouseEvent e) {
				EXTB.setIcon(i_EXTB);
			}
			@Override	//마우스 눌렀을떄
			public void mousePressed(MouseEvent e) {
				System.exit(1);
			}
		});
		add(EXTB);
		EXTB.setVisible(false);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
	}

	public void paint(Graphics g)
	{
		screenImage = createImage(SCREEN_WIDTH, SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		setFocusable(true);
		screenDraw(screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	public void screenDraw(Graphics g)
	{
		if (isEndPage == false && isFaint == false && isGamePage == true)
		{
			long temp;
			CRT_TIME = BGM.getTime();
			if (Midx != 0)
				remainTime = musicLength[Midx] - CRT_TIME;
			temp = CRT_TIME - PAST_TIME;
			PAST_TIME = CRT_TIME;
			if (temp < 17 && temp > 0)
				try {
					Thread.sleep(17 - temp);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		backGroundDraw(g);
		if (isGamePage == true)
		{
			stageDraw(CRT_TIME,g);
			noteDraw(CRT_TIME,g);
			charaterDraw(CRT_TIME,g);
			scoreDraw(g);
			timeDraw(0,remainTime,g);
		}
		//메인 페이지 이미지 출력
		if (isMainPage == true)
		{
			String fileName = "images/jumpMotion/yellow/jump20.png";
			Image motion = new ImageIcon(fileName).getImage();
			createFistStagereateFlat(0,false, false,g);
			g.drawImage(motion, 0, 275, null);
		}
		//선택 페이지 이미지 출력
		if (isSelectPage == true)
		{
			String fileName = "images/selectPage.png";
			Image image = new ImageIcon(fileName).getImage();
			g.drawImage(image, 140, 65, null);
			image = new ImageIcon(ablumArt[Midx]).getImage();
			g.drawImage(image, 390, 90, null);
		}
		//설명 페이지 이미지 출력
		if (isExplanePage == true)
		{
			String fileName = "images/explanePage.png";
			Image image = new ImageIcon(fileName).getImage();
			g.drawImage(image, 440, 90, null);
			image = new ImageIcon(explaneImage[eidx]).getImage();
			g.drawImage(image, 465, 115, null);
			image = new ImageIcon("images/explane0.png").getImage();
			g.drawImage(image, 465, 490, null);
		}
		if (CposY >= SCREEN_HEIGHT)
		{
			isEndPage = true;
		}
		if (isEndPage == true && isMainPage == false)
		{
			g.drawImage(i_EDP, 0, 0, null);
			EXTB.setVisible(true);
			RTYB.setVisible(true);
			MAINB.setVisible(true);
			GVUB.setVisible(false);
			paintComponents(g);
//			BGM.close();
		}
		else
			paintComponents(g);
		this.repaint();
	}
	public void backGroundDraw(Graphics g)
	{
		//배경색 드로우
		{
			BufferedImage temp = (BufferedImage) createImage(1, 1);
			if (isEndPage == false && isFaint == false && isGamePage == true)
				setha += 0.01;
			double colorR = 128 + 72*Math.sin(setha);
			double colorG = 128 + 72*Math.cos(setha);
			Color clr = new Color((int) colorR,(int) colorG, 205);
			temp.setRGB(0, 0, clr.getRGB());
			g.drawImage(temp, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT,null);
		}
		//문 드로우
		{
			if (isEndPage == false && isFaint == false && isGamePage == true)
				BposX3 -= BG_spd[3];
			double BposY = (BposX3 - 640)*(BposX3 - 640) /5826.6666 + 60;

//			System.out.println(BposX3 + " " + BposY);
			if (BposX3 <= -1 * SCREEN_WIDTH)
				BposX3 += 3*SCREEN_WIDTH;
			if (BposX3 <= SCREEN_WIDTH + 60 && BposX3 >= -60)
				g.drawImage(Backpart3, (int)BposX3 - 30, (int)BposY - 30, null);
		}
		//배경파트2 드로우
		{
			if (isEndPage == false && isFaint == false && isGamePage == true)
				BposX2-=BG_spd[2];
			g.drawImage(Backpart2, (int)BposX2, 0, null);
			g.drawImage(Backpart2, (int)BposX2+SCREEN_WIDTH, 0, null);
			if (BposX2 <= (-1*SCREEN_WIDTH))
				BposX2+=SCREEN_WIDTH;
		}
		//배경파트1 드로우
		{
			if (isEndPage == false && isFaint == false && isGamePage == true)
				BposX1-=BG_spd[3];
			g.drawImage(Backpart1, (int)BposX1, 0, null);
			g.drawImage(Backpart1, (int)BposX1+SCREEN_WIDTH, 0, null);
			if (BposX1 <= (-1*SCREEN_WIDTH))
				BposX1+=SCREEN_WIDTH;
		}
	}
	public void charaterMotion(Graphics g)
	{
		if(isFrameIcs== true)
		{
			//프레임의 초기값 -1일경우 프레임값 0으로
			if (Frame == -1 ) Frame = 0;

			if (motionChange == true && crtMotion != moveMotion)
			{
				motionChange = false;
				nextMotion = moveMotion;
			}

			//지금 모션이 달리기 걷기이고 다음 모션이 점프거나 슬라이딩 일때
			if ((nextMotion == motionKind[2] || nextMotion == motionKind[3] || nextMotion == motionKind[5]) &&
					(crtMotion == motionKind[1]|| crtMotion == motionKind[0]))
			{
				if ((Frame % 20 ==  0)||(Frame > MAX_FRAME ))
				{
					Frame = 0;
					crtMotion = nextMotion;
					nextMotion = moveMotion;
				}
			}
			else if (Frame > MAX_FRAME )
			{
				Frame = 0;
				crtMotion = nextMotion;
				nextMotion = moveMotion;
			}

		}
		//위에 막혀있고 지금모션이 슬라이딩도 아니고 넘어지는 모션도 아닐떄
		if (isBlocking == true && crtMotion != motionKind[3] && crtMotion != motionKind[4])
		{
			crtMotion = motionKind[4];
			Frame=0;
			isFaint = true;
		}

		String fileName = "images/"+crtMotion +"Motion/" + crtColor+"/"+ crtMotion +Frame +".png";

		Image motion = new ImageIcon(fileName).getImage();

		//넘어지는 모션이 끝까지 나왔을때
		if (crtMotion == motionKind[4] && Frame == MAX_FRAME)
		{
			isEndPage = true;	isFrameIcs = false;
		}
//		System.out.println(fileName);

//		System.out.println(isDowning+" "+ isStageBlank +" ");

//		System.out.println(crtMotion +" "+ nextMotion +" "+ moveMotion);

		CposY = 350;

		//날기 모션 처리
		if ((crtMotion == motionKind[6] && isFlyable == true) || (crtMotion == motionKind[6] && Frame >= 20))
		{
			if (Frame <= 20)
				CposY -= ((Frame *Frame ) / 5.33 );
			else
				CposY -=  ((Frame - 40) *(Frame -40) / 5.33);
			isDowning = false;
		}
		//지금 모션이 점프가 아니고 공백이거나 떨어지는 중일때
		else if (crtMotion != motionKind[2] && isStageBlank==true || isDowning == true)
		{
			isDowning = true;
			CposY += (blankCount*blankCount);
			blankCount++;
		}
		//점프 슬라이딩 Y좌표 처리
		else if (crtMotion == motionKind[2])
		{
			if (Frame <= 20)
				CposY -= ((Frame *Frame ) / 5.33 );
			else
				CposY -=  ((Frame - 40) *(Frame -40) / 5.33);
		}
		else if (crtMotion == motionKind[3])
		{
			if (Frame <= 20)
				CposY += ((Frame *Frame ) / 13.33 );
			else
				CposY += (((Frame-40) *(Frame-40) ) / 13.33 );
		}

		if(crtMotion == motionKind[6] && Frame == 20 && isFlyable == true)
		{
			String effectName = "";
			Image effectImage;
			if (flyLasting == 0)
			{
				for(int i = 0; i < N_FLYEFFECT ; i++)
					flyEffectPosY[i] = CposY;
			}
			if (flyLasting >= 45)
			{
				CposY += (int)(20*Math.sin(flySetha));
				// 세타처리
				flySetha += 0.1;
			}
			else
				flyLasting++;
			for(int i = 0 ; i < N_FLYEFFECT ; i++)
			{
				effectName = "images/flyMotion/Effect/"+crtColor+"Effect"+ i + ".png";
				effectImage = new ImageIcon(effectName).getImage();
				g.drawImage(effectImage, 0 - (9 - i)*(flyEffectDis/3), flyEffectPosY[i], null);

				if(i == N_FLYEFFECT - 1)
				{
					flyEffectPosY[i] = CposY;
				}
				else
				{
					flyEffectPosY[i] = flyEffectPosY[i+1];
				}
			}
			if (flyEffectDis <= MAX_FEDIS)
			{
				flyEffectDis++;
			}
		}
		//그리기
		g.drawImage(motion, 0, CposY, null);

		if(isFrameIcs == true)
		{
			//지금 모션이 슬라이딩일때
			if (crtMotion == motionKind[3])
			{
				if (Frame == 20)
				{
					if (slideLasting == 20)
					{
						Frame++;
						nextMotion = moveMotion;
						slideLasting = 0;
					}
					else if(slideLasting < 20)
					{
						slideLasting++;
					}
				}
				else
					Frame++;
			}
			else if (crtMotion == motionKind[5])
			{
				if (Frame == 20)
				{
					if (kickLasting == 10)
					{
						Frame++;
						nextMotion = moveMotion;
						kickLasting = 0;
					}
					else if(kickLasting < 10)
					{
						kickLasting++;
					}
				}
				else
					Frame++;
			}
			//지금 모션이 점프일때
			else if (crtMotion == motionKind[2])
			{
				FrameCount++;
				if (FrameCount==2)
				{
					Frame++; FrameCount = 0;
				}
			}
			//지금 모션이 달리기일때
			else if (crtMotion == motionKind[1] || crtMotion == motionKind[0])
			{
				if (nextMotion == motionKind[1] || nextMotion == motionKind[0])
				{
					FrameCount++;
					if (FrameCount==2)
					{
						Frame++; FrameCount = 0;
					}
				}
				else //!(nextMotion == motionKind[1] || nextMotion == motionKind[0])
				{
					FrameCount = 0;	Frame++;
				}
			}
			//지금 모션이 날기일때
			else if (crtMotion == motionKind[6])
			{
				FrameCount++;
				if (FrameCount==2)
				{
					Frame++; FrameCount = 0;
				}
				if (Frame > 20 && isFlyable == true)
					Frame = 20;
			}
			//그외의 경우
			else
				Frame++;
		}
	}
	public void moveMotionChange(long crt, long start_Time, String Motion)
	{
		if (Motion != motionKind[0] && Motion != motionKind[1])
			return;
		if (crt>= start_Time)
		{
			moveMotion = Motion;
		}
	}
	public void charaterDraw(long crt, Graphics g)
	{
		//moveMotionChange(crt, 3000, motionKind[1]);
		charaterMotion(g);
	}
	public void noteDraw(long crt,Graphics g)
	{
		createNote(LEFT	, 0, crt, 0,g);
		createNote(UP	,  500, crt, 1,g);
		createNote(RIGHT,  1000, crt, 2,g);
		createNote(DOWN ,  2000, crt, 3,g);
		createMotionNote(DOWN	,  3000, crt, 4,g);
		createNote(LEFT	,  6500, crt, 5,g);
		createMotionNote(UP	,  8000, crt, 6,g);
		createNote(UP	,  8800, crt, 7,g);
		createNote(DOWN	,  9300, crt, 8,g);
		createNote(LEFT	,  9800, crt, 9,g);
		createNote(UP		, 10300, crt, 10,g);
		createNote(RIGHT	,  11200, crt, 11,g);
		createMotionNote(DOWN	,  12000, crt, 12,g);
		createMotionNote(LEFT	,  16000, crt, 13,g);
		createWall( 16000, crt, 13,g);
		createNote(RIGHT	,  17500, crt, 14,g);
		createNote(DOWN	,  18000, crt, 15,g);
		createNote(LEFT	,  18500, crt, 16,g);
		createNote(UP	,  19000, crt, 17,g);
		createMotionNote(RIGHT	,  21000, crt, 18,g);

		createNote(LEFT,22200,crt,19,g);
		createNote(RIGHT,22600,crt,20,g);
		createNote(DOWN,23000,crt,21,g);
		createNote(DOWN,23400,crt,22,g);
		createNote(LEFT,23800,crt,23,g);
		createNote(RIGHT	,  24200, crt, 24,g);
		createNote(DOWN	,  24600, crt, 25,g);
		createNote(LEFT	,  25000, crt, 26,g);
		createNote(UP	,  25400, crt, 27,g);
		createNote(RIGHT,27500,crt,28,g);
		createNote(RIGHT,27800,crt,29,g);
		createNote(DOWN,28100,crt,30,g);
		createNote(UP,28400,crt,31,g);
		createNote(DOWN,28700,crt,32,g);
		createMotionNote(RIGHT	,  30000, crt, 33,g);

		createNote(LEFT,33600,crt,34,g);

		createNote(RIGHT	,  34000, crt, 35,g);
		createNote(DOWN	,  34400, crt, 36,g);
		createNote(LEFT	,  34800, crt, 37,g);
		createNote(UP	,  35200, crt, 38,g);

		createNote(LEFT,37000,crt,39,g);
		createNote(UP,37400,crt,40,g);
		createNote(LEFT,37800,crt,41,g);
		createNote(UP,38200,crt,42,g);
		createNote(DOWN,38600,crt,43,g);
		createNote(RIGHT,39000,crt,44,g);
		createMotionNote(UP,40500,crt,45,g);

		createMotionNote(DOWN,42500,crt,46,g);
		createMotionNote(LEFT,44800,crt,47,g);
		createWall(44700,crt,47,g);
		createMotionNote(DOWN,46500,crt,48,g);
		createMotionNote(UP,48500,crt,49,g);
		createNote(DOWN,49000,crt,50,g);
		createNote(RIGHT,49300,crt,51,g);
		createNote(LEFT,49600,crt,52,g);
		createMotionNote(LEFT,50500,crt,53,g);
		createWall(50400,crt,53,g);
		createNote(UP,51200,crt,54,g);
		createMotionNote(RIGHT,52000,crt,55,g);

		createNote(UP,52800,crt,56,g);
		createNote(UP,53100,crt,57,g);
		createNote(LEFT,53400,crt,58,g);
		createNote(RIGHT,53700,crt,59,g);
		createNote(LEFT,54000,crt,60,g);
		createNote(DOWN,54300,crt,61,g);
		createNote(LEFT,54600,crt,62,g);
		createNote(UP,54900,crt,63,g);
		createNote(DOWN,55200,crt,64,g);
		createNote(RIGHT,55500,crt,65,g);

		createNote(LEFT,56200,crt,66,g);
		createMotionNote(LEFT,57000,crt,67,g);
		createWall(56900,crt,67,g);
		createNote(LEFT,58200,crt,68,g);
		createNote(DOWN,58500,crt,69,g);
		createMotionNote(LEFT,59300,crt,70,g);
		createWall(59200,crt,70,g);
		createNote(LEFT,60000,crt,71,g);
		createNote(RIGHT,60300,crt,72,g);
		createMotionNote(RIGHT,61000,crt,73,g);
		createNote(UP,61700,crt,74,g);
		createNote(LEFT,62000,crt,75,g);
		createNote(UP,62300,crt,76,g);
		createNote(RIGHT,62600,crt,77,g);
		createNote(LEFT,62900,crt,78,g);
		createNote(DOWN,63200,crt,79,g);
		createNote(DOWN,63500,crt,80,g);
		createNote(RIGHT,63800,crt,81,g);
		createNote(UP,64200,crt,82,g);
		createNote(LEFT,64400,crt,83,g);
		createNote(RIGHT,64600,crt,84,g);
		createMotionNote(UP,65500,crt,85,g);
		createNote(LEFT,66000,crt,86,g);
		createNote(RIGHT,66300,crt,87,g);
		createMotionNote(DOWN,68000,crt,88 ,g);
		createMotionNote(LEFT,70000,crt,89,g);
		createWall(69900,crt,89,g);
		createNote(RIGHT,70600,crt,90,g);
		createNote(LEFT,70800,crt,91,g);
		createNote(LEFT,71000,crt,92,g);
		createNote(UP,71200,crt,93,g);
		createMotionNote(DOWN,72000,crt,94,g);
		createNote(LEFT,73300,crt,95,g);
		createNote(LEFT,73600,crt,96,g);
		createNote(DOWN,73900,crt,97,g);
		createMotionNote(RIGHT,74500,crt,98 ,g);

		createNote(RIGHT,75200,crt,99,g);
		createNote(DOWN,75400,crt,100,g);
		createNote(LEFT,75600,crt,101,g);
		createNote(UP,75800,crt,102,g);
		createNote(LEFT,76000,crt,103,g);
		createNote(DOWN,76200,crt,104,g);
		createNote(DOWN,76400,crt,105,g);
		createNote(RIGHT,76600,crt,106,g);
		createNote(LEFT,76800,crt,107,g);
		createNote(LEFT,77000,crt,108,g);
		createNote(UP,77200,crt,109,g);
		createNote(LEFT,77400,crt,110,g);
		createNote(DOWN,77600,crt,111,g);
		createNote(DOWN,77800,crt,112,g);
		createNote(RIGHT,78000,crt,113,g);


		createNote(DOWN,78800,crt,114,g);
		createNote(UP,79000,crt,115,g);
		createNote(UP,79200,crt,116,g);

		createMotionNote(DOWN,80000,crt,117,g);
		createNote(UP,81400,crt,118,g);
		createMotionNote(UP,82000,crt, 119,g);
		createNote(RIGHT,82800,crt,120,g);
		createNote(LEFT,83000,crt,121,g);
		createNote(LEFT,83200,crt,122,g);
		createNote(DOWN,83400,crt,123,g);
		createNote(UP,83600,crt,124,g);
		createNote(LEFT,83800,crt,125,g);
		createNote(RIGHT,84000,crt,126,g);
		createNote(RIGHT,84200,crt,127,g);
		createNote(RIGHT,84400,crt,128,g);
		createNote(DOWN,84600,crt,129,g);
		createNote(UP,84800,crt,130,g);
		createNote(RIGHT,85000,crt,131,g);
		createNote(LEFT,85200,crt,132,g);
		createNote(DOWN,85400,crt,133,g);
		createNote(DOWN,85600,crt,134,g);
		createNote(LEFT,85800,crt,135,g);
		createNote(RIGHT,86000,crt,136,g);
		createMotionNote(LEFT,86500,crt,137,g);
		createWall(86400,crt,137,g);
		createNote(UP,87000,crt,138,g);
		createNote(DOWN,87200,crt,139,g);
		createNote(DOWN,87400,crt,140,g);
		createMotionNote(LEFT,88000,crt,141,g);
		createWall(87900,crt,141,g);
		createNote(RIGHT,88500,crt,142,g);
		createNote(LEFT,88700,crt,143,g);
		createNote(RIGHT,88900,crt,144,g);
		createNote(UP,89100,crt,145,g);
		createNote(LEFT,89300,crt,146,g);
		createMotionNote(UP,90000,crt,147,g);
		createNote(LEFT,90800,crt,148,g);
		createNote(RIGHT,91000,crt,149,g);
		createNote(LEFT,91200,crt,150,g);
		createMotionNote(UP,92000,crt,151,g);
		createNote(UP,92700,crt,152,g);
		createNote(UP,92900,crt,153,g);
		createMotionNote(DOWN,93500,crt,154 ,g);
		createNote(RIGHT,95800,crt, 155,g);
		createNote(RIGHT,96200,crt,156,g);
		createNote(LEFT,96400,crt,157,g);
		createMotionNote(UP,97000,crt,158,g);
		createMotionNote(DOWN,98500,crt,159,g);
		createNote(UP,99900,crt,160,g);
		createNote(LEFT,100100,crt,161,g);

		createMotionNote(LEFT,101000,crt,162,g);
		createWall(100900,crt,162,g);

		createMotionNote(LEFT,102200,crt,163,g);
		createWall(102100,crt,163,g);

		createMotionNote(RIGHT,103500,crt,164,g);

		createNote(LEFT,104000,crt,165,g);
		createNote(LEFT,104200,crt,166,g);
		createNote(RIGHT,104500,crt,167,g);
		createNote(RIGHT,104700,crt,168,g);
		createNote(UP,105000,crt,169,g);
		createNote(RIGHT,105200,crt,170,g);
		createNote(UP,105400,crt,171,g);
		createNote(LEFT,105600,crt,172,g);
		createNote(RIGHT,105800,crt,173,g);
		createNote(DOWN,106000,crt,174,g);
		createNote(UP,106200,crt,175,g);
		createNote(LEFT,106400,crt,176,g);
		createNote(LEFT,106600,crt,177,g);
		createNote(UP,106900,crt,178,g);
		createNote(DOWN,107200,crt,179,g);
		createNote(UP,107500,crt,180,g);
		createNote(RIGHT,107800,crt,181,g);
		createNote(LEFT,10810,crt,182,g);
		createNote(DOWN,108300,crt,183,g);
		createNote(LEFT,109200,crt,184,g);

		createMotionNote(DOWN,110000,crt,185,g);
		createNote(UP,113000,crt,186,g);
		createNote(LEFT,113200,crt,187,g);
		createNote(RIGHT,113400,crt,188,g);
		createMotionNote(DOWN,114000,crt,189,g);
		createMotionNote(LEFT,117000,crt,190,g);
		createWall(116900,crt,190,g);
		createNote(RIGHT,117500,crt,191,g);
		createNote(LEFT,117800,crt,192,g);
		createNote(UP,118300,crt,193,g);
		createNote(DOWN,118500,crt,194,g);
		createNote(DOWN,118700,crt,195,g);
		createNote(RIGHT,118900,crt,196,g);
		createNote(DOWN,119100,crt,197,g);
		createNote(LEFT,119300,crt,198,g);
		createMotionNote(UP,120000,crt,199,g);
		createNote(RIGHT,121000,crt,200,g);
		createNote(RIGHT,121200,crt,201,g);
		createMotionNote(LEFT,121900,crt,202,g);
		createWall(121800,crt,202,g);
		createMotionNote(RIGHT,123000,crt,203,g);
		createNote(LEFT,124000,crt,204,g);
		createNote(DOWN,125000,crt,205,g);
		createNote(RIGHT,126000,crt,206,g);
		createNote(UP,126600,crt,207,g);
		createNote(DOWN,126900,crt,208,g);
		createNote(UP,127200,crt,209,g);
		createNote(LEFT,127400,crt,210,g);
		createNote(RIGHT,127600,crt,211,g);
		createMotionNote(DOWN,131000,crt,212,g);
		createMotionNote(LEFT,134800,crt,213,g);
		createWall(134700,crt,213,g);
		createMotionNote(UP,136300,crt,214,g);
		createNote(RIGHT,136900,crt,215,g);
		createNote(DOWN,137100,crt,216,g);
		createNote(UP,137300,crt,217,g);
		createMotionNote(UP,138000,crt,218,g);
		createMotionNote(DOWN,140000,crt,219,g);
		createNote(UP,141500,crt,220,g);
		createNote(DOWN,141800,crt,221,g);
		createNote(DOWN,142100,crt,222,g);
		createNote(RIGHT,142400,crt,223,g);
		createNote(LEFT,142700,crt,224,g);
		createMotionNote(LEFT,143500,crt,225,g);
		createWall(143400,crt,225,g);
		createNote(RIGHT,144000,crt,226,g);
		createNote(LEFT,144300,crt,227,g);
		createNote(LEFT,144600,crt,228,g);
		createNote(UP,144900,crt,229,g);
		createMotionNote(LEFT,145700,crt,230,g);
		createWall(145600,crt,230,g);

		createMotionNote(LEFT,147200,crt,231,g);
		createWall(147100,crt,231,g);

		createNote(LEFT,148100,crt,232,g);
		createNote(RIGHT,148900,crt,233,g);
		createNote(RIGHT,149200,crt,234,g);
		createMotionNote(UP,150000,crt,235,g);
		createNote(LEFT,150600,crt,236,g);
		createNote(LEFT,150800,crt,237,g);
		createMotionNote(RIGHT,151500,crt,238,g);
		createNote(UP,152000,crt,239,g);
		createNote(DOWN,152700,crt,240,g);
		createNote(UP,153400,crt,241,g);
		createNote(LEFT,154100,crt,242,g);
		createNote(LEFT,154800,crt,243,g);
		createNote(DOWN,155500,crt,244,g);

		createNote(DOWN,155800,crt,245,g);
		createNote(RIGHT,156100,crt,246,g);
		createNote(UP,156400,crt,247,g);
		createNote(UP,156800,crt,248,g);
		createNote(RIGHT,157200,crt,249,g);

		createNote(LEFT,158200,crt,250,g);
		createNote(UP,158600,crt,251,g);
		createNote(LEFT,159000,crt,252,g);
		createNote(RIGHT,159400,crt,253,g);
		createMotionNote(DOWN,160000,crt,254,g);
		createNote(UP,163500,crt,255,g);
		createMotionNote(LEFT,164500,crt,256,g);
		createWall(164400,crt,256,g);
		createMotionNote(LEFT,166000,crt,257,g);
		createWall(165900,crt,257,g);
		createMotionNote(UP,168000,crt,258,g);
		createNote(DOWN,168600,crt,259,g);
		createNote(LEFT,169000,crt,260,g);
		createMotionNote(DOWN,170000,crt,261,g);
		createNote(RIGHT,173800,crt,262,g);
		createNote(DOWN,174200,crt,263,g);
		createNote(DOWN,174600,crt,264,g);
		createNote(RIGHT,175000,crt,265,g);
		createNote(LEFT,176000,crt,266,g);
		createNote(DOWN,176400,crt,267,g);
		createNote(DOWN,176800,crt,268,g);

		createMotionNote(RIGHT,178000,crt,269,g);

		createNote(RIGHT,180000,crt,270,g);
		createNote(RIGHT,181000,crt,271,g);
		createNote(DOWN,182000,crt,272,g);
		createNote(LEFT,183000,crt,273,g);
		createNote(DOWN,184000,crt,274,g);

		createNote(DOWN,185500,crt,275,g);
		createNote(LEFT,186000,crt,276,g);
		createNote(LEFT,186500,crt,277,g);
		createNote(RIGHT,187000,crt,278,g);
		createNote(LEFT,187500,crt,279,g);
		createNote(UP,188000,crt,280,g);
		createNote(LEFT,188300,crt,281,g);
		createNote(RIGHT,188600,crt,282,g);
		createNote(LEFT,188900,crt,283,g);
		createNote(DOWN,189200,crt,284,g);
		createNote(UP,189500,crt,285,g);

		createNote(DOWN,190200,crt,286,g);
		createNote(DOWN,190500,crt,287,g);
		createNote(UP,191000,crt,288,g);
		createNote(UP,191300,crt,289,g);
		createNote(DOWN,191800,crt,290,g);
		createNote(DOWN,192100,crt,291,g);
		createNote(RIGHT,192600,crt,292,g);
		createNote(LEFT,192900,crt,293,g);
		createNote(RIGHT,193200,crt,294,g);
		createNote(DOWN,193500,crt,295,g);
		createNote(RIGHT,193800,crt,296,g);

		createMotionNote(LEFT,195000,crt,297,g);
		createWall(194900,crt,297,g);

		createMotionNote(LEFT,197000,crt,298,g);
		createWall(196900,crt,298,g);

		createNote(RIGHT,198000,crt,299,g);
		createNote(UP,198500,crt,300,g);
		createNote(LEFT,199000,crt,301,g);

		createMotionNote(UP,200000,crt,302,g);

		createNote(RIGHT,200600,crt,303,g);
		createNote(RIGHT,200800,crt,304,g);
		createMotionNote(DOWN,202000,crt,305,g);
		createNote(UP,205500,crt,306,g);
		createNote(LEFT,206000,crt,307,g);
		createNote(RIGHT,206500,crt,308,g);
		createNote(RIGHT,207000,crt,309,g);

		createMotionNote(UP,208000,crt,310,g);

		createNote(LEFT,209000,crt,311,g);
		createNote(DOWN,209300,crt,312,g);
		createNote(DOWN,209600,crt,313,g);

		createMotionNote(LEFT,211000,crt,314,g);
		createWall(210900,crt,314,g);

		createMotionNote(LEFT,212500,crt,315,g);
		createWall(212400,crt,315,g);
		createNote(RIGHT,213500,crt,316,g);
		createNote(LEFT,213800,crt,317,g);
		createNote(RIGHT,214100,crt,318,g);

		createMotionNote(RIGHT,215000,crt,319,g);

		createNote(UP,216000,crt,320,g);
		createNote(RIGHT,217000,crt,321,g);
		createNote(RIGHT,218000,crt,322,g);
		createNote(LEFT,219000,crt,323,g);
		createNote(DOWN,220000,crt,324,g);
		createNote(UP,221000,crt,325,g);

		createNote(LEFT,222500,crt,326,g);
		createNote(RIGHT,223000,crt,327,g);
		createNote(LEFT,223500,crt,328,g);
		createNote(DOWN,224000,crt,329,g);
		createNote(RIGHT,224500,crt,330,g);
		createNote(UP,225000,crt,331,g);
		createMotionNote(DOWN,226000,crt,332,g);

		createNote(UP,229500,crt,333,g);
		createNote(UP,229800,crt,334,g);
		createNote(UP,230100,crt,335,g);
		createNote(LEFT,230400,crt,336,g);
		createNote(RIGHT,230700,crt,337,g);
		createNote(UP,231000,crt,338,g);

		createMotionNote(UP,232000,crt,339,g);

		createMotionNote(LEFT,234000,crt,340,g);
		createWall(233900,crt,341,g);

		createNote(RIGHT,235000,crt,341,g);
		createNote(UP,2355000,crt,342,g);
		createNote(LEFT,236000,crt,343,g);
		createNote(DOWN,236500,crt,344,g);

		if (createNotePage == true)
		{
			note = new boolean[N_note];
			noteEffect = new int[N_note];
			for (int i = 0 ; i < N_note; i++)
			{
				note[i] = false;
				noteEffect[i] = 0;
			}
			createNotePage = false;
		}

		System.out.println(N_note);
		//System.out.println(Arrays.toString(note));
		//System.out.println(Arrays.toString(noteEffect));
	}
	public void createNote(int kind, long node_Time, long crt, int order,Graphics g)
	{
		if (createNotePage)
		{
			N_note++; return;
		}
		if(noteEffect[order] > 14)
			return;
		long gap = crt - node_Time;
		int posX = SCREEN_WIDTH -(int) ((double) gap / GameSPD);
		if (posX <= -240) return;
		if (gap >= 0)
		{
			if (kind <=4)
			{
				int posY = 470;		//350 + 120
				int flyprocessing = 0;
				//날기 상태 y좌표 처리
				if (isFlyable == true && crtMotion == motionKind[6])
				{
					if (Frame <= 20)
						posY -= ((Frame *Frame ) / 5.33 );
					else
						posY -=  ((Frame - 40) *(Frame -40) / 5.33);
					if (Frame == 20)
						posY -= 20*Math.sin(flySetha);
					flyprocessing = 40;
				}
				if (noteEffect[order] > 0)
				{
					createNoteEffect(kind,posX,posY,order,g);
					return;
				}
				else if (posX >=145 + flyprocessing &&posX <= 280 + flyprocessing &&input[kind-1] && note[order] == false && isDowning == false )
				{
					switch(kind)
					{
						case LEFT:crtColor = "sky";break;
						case RIGHT:crtColor = "pink";break;
						case UP:crtColor = "yellow";break;
						case DOWN:crtColor = "green";break;
					}
					createNoteEffect(kind,posX,posY,order,g);
					note[order] = true;
					SCORE+=200;
					return;
				}
				if (posX >= 0 - KEY_WIDTH)
					switch(kind)
					{
						case LEFT:g.drawImage(i_LKEY, posX, posY,null);		break;
						case RIGHT:g.drawImage(i_RKEY, posX, posY,null);	break;
						case UP:g.drawImage(i_UKEY, posX, posY,null);			break;
						case DOWN:g.drawImage(i_DKEY, posX, posY,null);	break;
					}
			}
		}
	}
	public void createMotionNote(int kind, long node_Time, long crt, int order,Graphics g)
	{
		if (createNotePage)
		{
			N_note++; return;
		}
		long gap = crt - node_Time;
		// posX 가 60 보다 작으면 리턴 60은 노드사이즈
		int posX = SCREEN_WIDTH -(int) ((double) gap/ GameSPD) - (int)(400 / GameSPD);
		if (posX <= -60) return;
		if (gap >= -1000)
		{
			if (kind <=4)
			{
				int posY = 600;
				if (posX <= 360 && note[order] == false)
				{
					motionChange = true;
				}
				if (posX >=145 &&posX <= 280 &&input[kind-1] && note[order] == false && isDowning == false  || note[order] == true)
				{
					if (posX >=145 &&posX <= 280 &&input[kind-1] && note[order] == false && isDowning == false )
						crtColor = "purple";
					switch(kind)
					{
						case UP:g.drawImage(i_JKEY_C, posX, posY,null);break;
						case DOWN:g.drawImage(i_SKEY_C, posX, posY,null);break;
						case LEFT:g.drawImage(i_KKEY_C, posX, posY,null); break;
						case RIGHT:g.drawImage(i_FKEY_C, posX, posY,null); break;
					}
					if (kind == RIGHT &&note[order] == false)
					{
						isFlyable = true;
						flyEffectDis = 0;
						flySetha = 0;
						flyLasting = 0;
					}
					if(note[order] == false)
						SCORE+=300;
					note[order] = true;
					return;
				}
				if (posX >= 0 - KEY_WIDTH)
					switch(kind)
					{
						case UP:g.drawImage(i_JKEY, posX , posY,null);g.drawImage(i_EFFECT, posX, posY-85,null);break;
						case DOWN:g.drawImage(i_SKEY, posX, posY,null);g.drawImage(i_EFFECT, posX, posY-85,null);break;
						case LEFT:g.drawImage(i_KKEY, posX, posY,null);g.drawImage(i_EFFECT, posX, posY-85,null);break;
						case RIGHT:g.drawImage(i_FKEY, posX, posY,null);g.drawImage(i_EFFECT, posX, posY-85,null);break;
					}
			}
		}
	}
	public void createNoteEffect(int kind,int posX,int posY, int order,Graphics g)
	{
		if (kind > 4 || kind < 1) return;
		String fileName ="";
		switch(kind)
		{
			case LEFT: fileName = "images/key/leftKey"+noteEffect[order]+".png";break;
			case RIGHT: fileName = "images/key/rightKey"+noteEffect[order]+".png";break;
			case UP: fileName = "images/key/upKey"+noteEffect[order]+".png";break;
			case DOWN: fileName = "images/key/downKey"+noteEffect[order]+".png";break;
		}
		noteEffect[order]++;
		Image tempImage = new ImageIcon(fileName).getImage();
		g.drawImage(tempImage, posX - 90, posY - 90, null);
//		System.out.println(fileName);
	}
	public void stageDraw(long crt,Graphics g)
	{
		isStageBlank = true; isBlocking = false;
		createFistStagereateFlat(crt,false, false,g);


		createFlat(crt,0, 3000,false, false,g);

		createSlideStage(crt,3000, 6000 ,false, false,g);
		createFlat(crt,6000, 8000 ,false, true,g);
		createFlat(crt,8400, 12000 ,true, false,g);

		createSlideStage(crt,12000, 15000 ,false, false,g);
		createFlat(crt,15000, 21000 ,false, true,g);
		createFlat(crt,26000,30000,true,true,g);
		createFlat(crt,35500, 40500 ,true, true,g);
		createFlat(crt,40900,42500,true,false,g);
		createSlideStage(crt,42500,43500,false,false,g);
		createFlat(crt,43500,46500,false,false,g);
		createSlideStage(crt,46500,47500,false,false,g);
		createFlat(crt,47500,48500,false,true,g);
		createFlat(crt,48900,52000,true,true,g);
		createFlat(crt,56000,61000,true,true,g);
		createFlat(crt,64100,65500,true,true,g);
		createFlat(crt,65900,68000,true,false,g);
		createSlideStage(crt,68000,69000,false,false,g);
		createFlat(crt,69000,72000,false,false,g);
		createSlideStage(crt,72000,73000,false,false,g);
		createFlat(crt,73000,74500,false,true,g);
		createFlat(crt,78600,80000,true,false,g);
		createSlideStage(crt,80000,81000,false,false,g);
		createFlat(crt,81000,82000,false,true,g);
		createFlat(crt,82400,90000,true,true,g);
		createFlat(crt,90400,92000,true,true,g);

		createFlat(crt,92400,93500,true,false,g);

		createSlideStage(crt,93500,95000,false,false,g);

		createFlat(crt,95000,97000,false,true,g);

		createFlat(crt,97400,98500,true,false,g);
		createSlideStage(crt,98500,99500,false,false,g);
		createFlat(crt,99500,103500,false,true,g);


		createFlat(crt,108700,110000,true,false,g);

		createSlideStage(crt,110000,112500,false,false,g);

		createFlat(crt,112500,114000,false,false,g);

		createSlideStage(crt,114000,116000,false,false,g);

		createFlat(crt,116000,120000,false,true,g);

		createFlat(crt,120400,123000,true,true,g);

		createFlat(crt,128000,131000,true,false,g);
		createSlideStage(crt,131000,134000,false,false,g);
		createFlat(crt,134000,136400,false,true,g);
		createFlat(crt,136700,138000,true,true,g);

		createFlat(crt,138400,140000,true,false,g);

		createSlideStage(crt,140000,141000,false,false,g);
		createFlat(crt,141000,150000,false,true,g);
		createFlat(crt,150400,151500,true,true,g);

		createFlat(crt,158000,160000,true,false,g);
		createSlideStage(crt,160000,163000,false,false,g);
		createFlat(crt,163000,168000,false,true,g);
		createFlat(crt,168400,170000,true,false,g);
		createSlideStage(crt,170000,173000,false,false,g);
		createFlat(crt,173000,178000,false,true,g);

		createFlat(crt,190000,200000,true,true,g);
		createFlat(crt,200400,202000,true,false,g);
		createSlideStage(crt,202000,205000,false,false,g);
		createFlat(crt,205000,208000,false,true,g);

		createFlat(crt,208400,215000,true,true,g);

		createFlat(crt,222000,226000,true,false,g);
		createSlideStage(crt,226000,229000,false,false,g);
		createFlat(crt,229000,232000,false,true,g);
		createFlat(crt,232400,250000,true,true,g);
	}
	public void createFistStagereateFlat(long crt,boolean round_S, boolean round_E,Graphics g)
	{
		createFlat(crt,(long)(-1*SCREEN_WIDTH* GameSPD), 0, round_S, round_E,g);
	}
	public void createFlat(long crt, long start_Time,long end_Time,boolean round_S, boolean round_E,Graphics g)
	{
		long gap = crt - start_Time;
		if (gap < 0)	return;
		int posX = (int) (SCREEN_WIDTH - gap/ GameSPD);
		int size = (int) Math.ceil((end_Time - start_Time)/STAGE_WIDTH/ GameSPD);

		//	맨끝에 그리는 그림이 일정량 보다 작으면 함수를 리턴한다.
		if (posX + ((size-1)*STAGE_WIDTH) <= 0 - STAGE_WIDTH)
			return;

		if (posX <= SCREEN_WIDTH +( (size-1)*STAGE_WIDTH))
		{
			for (int i = 0 ; i < size; i ++)
			{
				int drawPosX = posX +  i * STAGE_WIDTH;
				if (drawPosX > 255 && start_Time == (long)(-1*SCREEN_WIDTH*GameSPD))
				{
//					System.out.println("!!!!");
					isStageBlank = false; blankCount = 0; isDowning = false;
				}
				else if (drawPosX >= 185 && drawPosX <= 205 && isDowning == false)
				{
					isStageBlank = false;	  blankCount = 0;
				}
				if (i == 0)
				{
					if (round_S)
						g.drawImage(i_STAGE2, drawPosX, 350, null);
					else
						g.drawImage(i_STAGE0, drawPosX, 350, null);

					if (drawPosX >= 185 + (400/GameSPD)&& drawPosX <= 205 + (400/GameSPD))
					{
						flySetha = 0;
						isFlyable = false;
					}
					if (drawPosX >= 185 + (400/GameSPD)&& drawPosX <= 205 + (400/GameSPD))
					{
						flySetha = 0;
						isFlyable = false;
					}
				}
				else if (i == size-1)
				{
					if (round_E)
						g.drawImage(i_STAGE1, drawPosX, 350, null);
					else
						g.drawImage(i_STAGE0, drawPosX, 350, null);

//					if (drawPosX <= 220 && crtMotion != motionKind[2] && crtMotion != motionKind[3])
//						motionChange = false;
				}
				else
					g.drawImage(i_STAGE0,drawPosX, 350, null);
			}
		}
	}
	public void createSlideStage( long crt, long start_Time, long end_Time, boolean round_S, boolean round_E, Graphics g)
	{
		long gap = crt - start_Time;
		if (gap < 0)	return;
		int posX = (int) (SCREEN_WIDTH - gap/GameSPD);
		int size = (int) Math.ceil((end_Time - start_Time)/STAGE_WIDTH/GameSPD);

		//	맨끝에 그리는 그림이 일정량 보다 작으면 함수를 리턴한다.
		if (posX + ((size-1)*STAGE_WIDTH) <= 0 - (STAGE_WIDTH * 2))
			return;

		if (posX <= SCREEN_WIDTH +( (size-1)*STAGE_WIDTH))
		{
			for (int i = 0 ; i < size; i ++)
			{
				int drawPosX = posX +  i * STAGE_WIDTH;
				if (drawPosX > 255 && start_Time == (long)(-1*SCREEN_WIDTH*GameSPD))
				{
					isStageBlank = false; blankCount = 0; isDowning = false;
				}
				else if (drawPosX >= 185 && drawPosX <= 205 && isDowning == false)
				{
					if(crtMotion == motionKind[3])
						isSlideSucc = true;
					isBlocking = true;
					isStageBlank = false;	  blankCount = 0;
				}
				if (i == 0)
				{
					if (isSlideSucc && drawPosX <= 225)
					{
						if (round_S)
							g.drawImage(i_STAGE2C, drawPosX, 350, null);
						else
							g.drawImage(i_STAGE0C, drawPosX, 350, null);

						g.drawImage(i_BLOCK2C, drawPosX, 350 + 30, null);
					}
					else
					{
						if (round_S)
							g.drawImage(i_STAGE2, drawPosX, 350, null);
						else
							g.drawImage(i_STAGE0, drawPosX, 350, null);

						g.drawImage(i_BLOCK2, drawPosX, 350 + 30, null);
					}
				}
				else if (i == size-1)
				{
					if ( drawPosX <= 230)
						slideLasting = 20;

					if (isSlideSucc  && drawPosX <= 225)
					{
						if (round_E)
							g.drawImage(i_STAGE1C, drawPosX, 350, null);
						else
							g.drawImage(i_STAGE0C, drawPosX, 350, null);

						g.drawImage(i_BLOCK1C, drawPosX, 350 + 30, null);
					}
					else
					{
						if (round_E)
							g.drawImage(i_STAGE1, drawPosX, 350, null);
						else
							g.drawImage(i_STAGE0, drawPosX, 350, null);

						g.drawImage(i_BLOCK1, drawPosX, 350 + 30, null);
					}

					if (drawPosX <= -20) isSlideSucc = false;
					if (drawPosX <= 220 && crtMotion == moveMotion)
						motionChange = false;
				}
				else
				{
					if (isSlideSucc && drawPosX <= 225)
					{
						g.drawImage(i_STAGE0C,drawPosX, 350, null);

						g.drawImage(i_BLOCK0C, drawPosX, 350 + 30, null);
					}
					else
					{
						g.drawImage(i_STAGE0,drawPosX, 350, null);

						g.drawImage(i_BLOCK0, drawPosX, 350 + 30, null);
					}
				}
			}
		}
	}
	public void createWall(long node_Time, long crt, int order,Graphics g)
	{
		if (createNotePage)
		{
			return;
		}
		if(noteEffect[order] > 38) return;
		long gap = crt - node_Time;
		// posX 가 60 보다 작으면 리턴 60은 노드사이즈
		int posX = SCREEN_WIDTH -(int) ((double) gap/GameSPD) + (int)( 360 / GameSPD);
		if (posX <= -230) return;
		if (gap >= -1000)
		{
			if (posX >= 220 && posX <= 280 && crtMotion == motionKind[5]  && Frame >= 10 || noteEffect[order] >= 1)
			{
				int posY = 345;
				String fileName = "";
				int idx = noteEffect[order] / 2;
				fileName = "images/wall/wall" + idx + ".png";
				Image tempImage = new ImageIcon(fileName).getImage();
				g.drawImage(tempImage, posX, posY,null);
				noteEffect[order]++;
//				System.out.println(fileName);
			}
			// 실패
			else if (posX >= 220 && posX <= 280 && crtMotion != motionKind[5] && crtMotion != motionKind[4])
			{
				int posY = 425;
				crtMotion = motionKind[4];
				Frame=0;
				isFaint = true;
				g.drawImage(i_WALL, posX, posY,null);
			}
			//대기
			else
			{
				int posY = 425;
				g.drawImage(i_WALL, posX, posY,null);
			}
		}
	}
	public void scoreDraw(Graphics g)
	{
		if(SCORE >= MAX_SCORE) SCORE = MAX_SCORE;
		String scoreString = String.format("%06d", SCORE);

		String fileName ="images/number/score.png";
		Image tempImage = new ImageIcon(fileName).getImage();
		g.drawImage(tempImage,0,30,null);
		int temp;
		for(int i = 0 ; i < 6 ; i++)
		{
			temp = Integer.parseInt(Character.toString(scoreString.charAt(i)));
			fileName ="images/number/"+temp+".png";
			tempImage = new ImageIcon(fileName).getImage();
			g.drawImage(tempImage,217+i*40,30,null);
		}
//		System.out.println("      "+SCORE + " " + scoreString);
	}
	public void timeDraw(int kind ,long remain,Graphics g)
	{
		long temp = remain;
		temp = temp / 1000;
		System.out.println(temp);
		String min = Integer.toString((int) (temp / 60));
		String sec = String.format("%02d", (temp % 60));

		String fileName ="images/number/clock.png";
		Image tempImage = new ImageIcon(fileName).getImage();
		g.drawImage(tempImage, 5,90,null);

		//분 출력
		temp = Integer.parseInt(Character.toString(min.charAt(0)));
		fileName ="images/number/"+temp+".png";
		tempImage = new ImageIcon(fileName).getImage();
		g.drawImage(tempImage,70,90,null);
		//: 출력
		fileName ="images/number/crone.png";
		tempImage = new ImageIcon(fileName).getImage();
		g.drawImage(tempImage,110,90,null);

		for(int i = 0 ; i < 2 ; i++)
		{
			temp = Integer.parseInt(Character.toString(sec.charAt(i)));
			fileName ="images/number/"+temp+".png";
			tempImage = new ImageIcon(fileName).getImage();
			g.drawImage(tempImage,125+i*40,90,null);
		}

	}
	public void MainPage()
	{
		BGM.close();
		BGM = new Music(selectList[0], true);
		BGM.start();
		isMainPage = true;
		isSelectPage = false;
		isExplanePage = false;
		isGamePage = false;
		isEndPage = false;
		isFaint = false;
		isDowning = false;
		STTB.setVisible(true);
		EXTB.setVisible(false);
		RTYB.setVisible(false);
		MAINB.setVisible(false);
		GVUB.setVisible(false);
		LFB.setVisible(false);
		RTB.setVisible(false);
		SLB.setVisible(false);
		NTB.setVisible(false);
		PYB.setVisible(false);
		eidx = 0;
		Midx = 0;
		Frame = -1;
		FrameCount = 0;
		isFrameIcs = true;
		motionChange = false;
		crtColor = "none";
		crtMotion = motionKind[0];
		nextMotion = motionKind[0];
		moveMotion = motionKind[0];
	}
	public void selectPage()
	{
		isFaint = false;
		isEndPage = false;
		isGamePage = false;
		isMainPage = false;
		isSelectPage = true;
		isExplanePage = false;
		STTB.setVisible(false);
		EXTB.setVisible(false);
		RTYB.setVisible(false);
		MAINB.setVisible(false);
		GVUB.setVisible(false);
		LFB.setVisible(true);
		RTB.setVisible(true);
		SLB.setVisible(false);
	}
	public void explanePage()
	{
		isFaint = false;
		isEndPage = false;
		isGamePage = false;
		isMainPage = false;
		isSelectPage = false;
		isExplanePage = true;
		STTB.setVisible(false);
		EXTB.setVisible(false);
		RTYB.setVisible(false);
		MAINB.setVisible(false);
		GVUB.setVisible(false);
		LFB.setVisible(false);
		RTB.setVisible(false);
		SLB.setVisible(false);
		NTB.setVisible(true);
		PYB.setVisible(false);

	}
	public void gameStart()
	{
		BGM.close();
		BGM = new Music(BGMList[Midx], false);
		BGM.start();
		isMainPage = false;
		isSelectPage = false;
		isExplanePage = false;
		isGamePage = true;
		isEndPage = false;
		isFaint = false;
		isDowning = false;
		STTB.setVisible(false);
		EXTB.setVisible(false);
		RTYB.setVisible(false);
		MAINB.setVisible(false);
		GVUB.setVisible(true);
		LFB.setVisible(false);
		RTB.setVisible(false);
		SLB.setVisible(false);
		NTB.setVisible(false);
		PYB.setVisible(false);
		eidx = 0;
		Frame = -1;
		FrameCount = 0;
		isFrameIcs = true;
		motionChange = false;
		crtColor = "none";
		crtMotion = motionKind[1];
		nextMotion = motionKind[1];
		moveMotion = motionKind[1];
		createNotePage = true;
	}
	public void retry()
	{
		gameStart();
	}
}
class Music extends Thread {

	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Music(String musicName, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(musicName);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	public long getTime()
	{
		if(player == null)
			return 0;

		return  player.getPosition();
	}
	public void close()
	{
		isLoop = false;
		player.close();
		this.interrupt();
	}
	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	public String getFileName()
	{
		return file.getName();
	}
}
public class TEST
{
	public static void main(String[] args)
	{
		new Fake();
	}
}