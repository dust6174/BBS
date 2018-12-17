drop database BBS;
CREATE DATABASE BBS DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
	use  BBS;

	create table user
		(
			userid int primary key not null,
			username varchar(255),
			userpassword varchar(255),
			islock boolean default false
			);
	create table administrator
		(
			 adminid int primary key,
			 adminname varchar(255),
			 adminpassword varchar(255) 
			);
	create table board
		(
			boardid int  primary key AUTO_INCREMENT not null,
			boardtitle varchar(255),
			boardsign varchar(255)
			);
	create table poster
		(
			posterid int primary key AUTO_INCREMENT,
			boardid int,
            userid int,
			counter int default 0,
			postertitle varchar(255) not null ,
			postercontent text,
			seqnum int default 0,
			postertime datetime,
			foreign key (boardid) references board(boardid),
			foreign key (userid) references user(userid)
			)AUTO_INCREMENT = 1;
	create table reply
		(
			replyid int primary key AUTO_INCREMENT,
			posterid int,
			userid int,
			replycontent text,
			replytime datetime,
			foreign key (posterid) references poster(posterid),
			foreign key (userid) references user(userid)
			)AUTO_INCREMENT = 1;
insert into user (userid,username,userpassword) values(123,'666','666');
insert into user (userid,username,userpassword) values(456,'2333','2333');	

insert into administrator values(123,'666','666');
insert into administrator values(456,'2333','2333');

insert into board (boardtitle,boardsign) values ('自然科学','南朝论坛自然科学板块：您可以在此尽情的讨论进化论、相对论、弦论，反正大家都不懂'); 	
insert into board (boardtitle,boardsign) values ('影评书刊','南朝论坛影评书刊板块：您可以在此分享您看过的好书、好电影');
insert into board (boardtitle,boardsign) values ('近代战争','南朝论坛近代战争板块：欢迎您在此分享您的真知灼见');
insert into board (boardtitle,boardsign) values ('古代战争','南朝论坛古代战争板块：欢迎您在此分享您的真知灼见');
insert into board (boardtitle,boardsign) values ('南朝明研室','南朝论坛明研室板块：皇汉集散地，欢迎大家在此商业互吹');
insert into board (boardtitle,boardsign) values ('留言板','南朝论坛留言板，您可以在此留下您的意见和建议，反正我们也不会看');

insert into poster(boardid,userid,postertitle,postercontent,postertime)values(5,123,'髡事指录','髡人用夷字
髡人善百工，诸项造办营建无所不利，其匠心精巧之处，胜于红毛夷百倍。然文字之粗鄙相类，可嗟可叹。
崇祯中，予偶得髡人话本曰《南海风雷》者，虽印制精美，然其中文字多缺划也。同观诸友愕之，谓髡人之讳何其多也，岂非动辄得咎乎。有知髡情者曰，髡虽宋后，然久居海外，亦染夷风矣。其文字多行简化，又以红毛夷文标注，曰利于开蒙也。
予及诸友皆惊，以夷变夏者，莫之为甚也。呜呼，髡虽擅工，然轻易圣人文字，是自弃根本也，知者不取也欤！
澳宋鄙凶
神州者澳宋，万里者髡所盘踞琼府诸县也。
此句言髡志，谓澳宋虽迢遥万里，不可间髡民心也。
或云此句逞其凶志，欲混澳宋华夏为一而奄有者。
髡心难测，余不能决也，聊备识者。闻髡酋颇以“大天使长”自许，盖泰西天主教“圣徒”、“天使”之属，其犹中国神仙上帝类耳。
如是，则其所从来必目为神仙国矣。或闻髡吟诗云“六亿神州尽舜尧”，可为旁证。
髡夷文字考
髡夷虽远渡而来，然百工诸技皆精，造办火铳巨炮，营建城池屋舍，类红毛夷，然精于红毛夷倍矣。余于崇祯中得髡夷自用《南海风雷》话本，印制精美，字虽细，昏中依旧可辨。其中文字多缺划也，同观之诸友愕之，以为髡夷之讳何其多也，真如是，岂非动辄得咎乎。后得知，髡夷久居海外，亦受夷变矣，变我华夏文字为髡夷之简化字，又以红毛夷之夷文为标，注音于学校之课本，可收识辨生字，开化童蒙之奇效。呜呼哀哉，三代后，吾堂堂华夏，亦夷变哉。
澳乐
髡人居海外数百年，诗书尤记，礼乐全失。其制度仪典，与中华殊异，而近于番夷。而所用音乐，亦与夷乐相近，然又有大不同处。余在洪督幕中，数睹髡人军中行礼，盖迎送真髡也。奏乐皆为长号鼙鼓，军士数百列队齐唱军歌。并无丝竹，亦无乐工歌伎，其音高亢浑重，声震天地，虽只数百人，其威凛然不可犯也。真髡亦肃立高唱，神情肃穆，此与官军大不同者也。
尝闻海商过临高者言，髡人白日每于城中奏乐，乐声弥天，通城可闻。其俗乐与军乐迥异，轻灵促急，变化多端。彼又为余吟唱一韵，言是髡人市中常奏之曲，其婉转缠绵，大异华声。不知髡人以数十乐器齐奏此曲，又是何光景，余常恨不得亲往一闻耳。
髡人贺岁
髡人纪年以澳宋历，与西人历相仿佛，参用大明历。亦有正月、元宵、端午、中秋诸节。每至除夕，髡人集诸手下假髡从事，及所在士绅官员，大会于髡人治所。置大席于中庭，厚设盛馔，水陆杂陈，珍馐美食，数不胜数。其间不设席次，亦无座位，听凭大众自取。
席间有歌舞助兴，间有诸般玩意以资笑乐。髡人诸高官皆出，敬酒致礼贺岁，称“团拜会”。此乃澳洲旧俗，自澳洲传来者。报事者往来奔走，呈髡人各部所上贺岁折，依次诵读，每读一折，与会者辄鼓掌以致敬。
尽欢至夜分，则燃烟火数十，冲天而起数百丈，砰然四散，其色多变，姹紫嫣红，光华满堂，观者叹为观止。而后奏《难忘今宵》一曲，众人欢饮一杯，鼓掌而散。
髡人俗，度岁休沐七日，衙署俱停不理事，称“春节长假”。
《难忘今宵》有云：“神州万里同怀抱”。神州者澳宋，万里者髡所盘踞琼府诸县也。此句言髡志，谓澳宋虽迢遥万里，不可间髡民心也。或云此句逞其凶志，欲混澳宋华夏为一而奄有者。髡心难测，余不能决也，聊备识者。闻髡酋颇以“大天使长”自许，盖泰西天主教“圣徒”、“天使”之属，其犹中国神仙上帝类耳。如是，则其所从来必目为神仙国矣。或闻髡吟诗云“六亿神州尽舜尧”，可为旁证。','2018-11-14 22:00:00');
insert into poster(boardid,userid,postertitle,postercontent,postertime)values(1,123,'机械工业的奠基','“你们造的这设备间隙有点大了吧！”林汉隆手里把两片刚刚磨好的透镜放到袁好问的办公桌上，“你自己看看用你们的设备磨出来的镜片。”
说着，林汉隆把双手往胸前一抱，玩味地看着面前的机械口元老袁好问。袁好问随手打开工作灯，抽了一张白纸铺在工作台上，慢慢拿一片透镜放在纸上，又把另一片透镜叠放上去，于是便看到了彩色的条纹——这边是由于等厚干涉效应产生的牛顿环——当然，这是原时空的叫法，在这里，它们叫林汉隆环。
不过此时的林汉隆环却实在不像是圆环的样子——有的是椭圆形，有的是鸭蛋形，有的地方许多条纹挤在一起，反正不能称之为圆环。
“汉隆，看这条纹密度和范围，这球面的球半径应该接近百米了吧，”袁好问又不慌不忙地说“这已经是镜片研磨机能加工的极限了，您磨这样的镜片要用到哪儿去呢？”
林汉隆心里一惊，本来他磨制这两片镜片就是为了考验新接收的镜片研磨机的精度，并没有想什么实际用途，没想到这机械口的袁好问居然看穿了，便说：“我也就是为了检测精度，还没想实际用途呢。不过，历史上在消色差技术成熟之前，曾出现过几十米焦距的透镜……”
“那也不用近百米的球半径吧！”没等林汉隆说完，袁好问便打断了他，“不过我们机械口还真需要这样的大半径弧面设备，要不是看你天天为了海军陆军的测距仪望远镜炮队镜忙不过来，早就向执委会打报告啦，”
袁好问说着站起来搭上了林汉隆的肩膀，“旧时空钳工的框式水平仪，分度值是0.02mm/1m，当时机械口没个正经钳工，这种设备只带了十几套，现在哪个单位用不到？我这儿也只有俩，平时只敢用一个，都不敢让归化民碰。”
林汉隆说着摸了钥匙打开大理石平板旁边的柜子，取出了一个大木盒，上面赫然写着“框式水平仪”，和一行小字“上海量具刃具厂”。
袁好问打开盒子，从中取出一个30公分见方的金属框，立在一边的大理石平板上，说：”这就是了。“
林汉隆仔细端详起来，只见这金属方框约5厘米宽，四面平直，有特殊的花纹，底部和左侧的平面上有约三厘米宽的V形槽，想必是为了方便测量圆柱体；框体底部内侧镶有一大一小两个水准器，内有气泡；大水准器与框体平行，小水准管与框体垂直；一侧还有上海量具刃具厂的徽记和20um/m的字样。此时，大水准器中的气泡正稳稳地停在中央。
“主水准器上的刻度间隔约两毫米，对应的弧度半径可就是一百米了。“袁好问见林汉隆看得仔细，在他身后慢慢说道。
”怪不得你当时立马就同意把镜片研磨机的极限设置成100米”林汉隆恍然大悟：“没想到咱俩一个光学口、一个机械口，怎么就想到一块去了呢？就算为了你们机械口自己，你也要想办法提高镜片研磨机的精度！“说着笑了起来。
”你还说呢，这可是个大工程！“袁好问不知从哪儿拿了两瓶格瓦斯，递给林汉隆一瓶之后，自己灌喝了一口，慢慢说道：“我猜得到这些光学设备会出问题。因为精度是很昂贵的。”
袁好问慢慢开始打开了话匣子：“大家都知道，标准化的核心是精度的控制与管理，而精度靠什么来实现？”
“靠检测！”林汉隆刚喝了一口格瓦斯，加上之前谈的开心，于是果断地插话了。
“对，靠检测，或者说，靠测量来保证。”袁好问顿了顿，“测量要依靠什么？”
“量具！”林汉隆果断地说道。
“对，问题就出在量具上！”袁好问把格瓦斯往办公桌上一墩，开始长篇大论：
“零件的精度靠工具加工和量具测量来保证，量具的精度由谁来保证呢？那就是计量工作。比如说，旧时空的工厂里，每个游标卡尺都是半年由计量局检定一次的，精度不达标就要修理或报废，当让后来就是买新的，不光是游标卡尺，天平、砝码、温度计、电压表、秒表哪个不是量具？我们现在D日以后这么久了都一直没顾得上这个，加上这样超负荷使用，估计得有一半的量具需要修理甚至报废。也正因如此，设计精度无法保证，才让你们那批设备出了问题。”袁好问喝了口格瓦斯，继续道：
“旧时空的计量学共分成十类，我觉得机械工业依赖其中的‘几何量计量’和‘力学计量’两类。其中几何量计量严重依赖你们的光学设备。比如迈克尔逊干涉仪，毕竟光学测量方法精度高嘛！”
林汉隆这才明白为何袁好问对自己如此热情。便接着话题说：“迈克尔逊干涉仪不太难做，只不过我对你说的‘计量’一窍不通，怕做出来你们不好用呀。”袁好问见林汉隆已然上钩，大喜：“这不妨事，机械加工我负责，我还有旧时空的计量用干涉仪资料，这可是全新的领域，咱俩一起给他搞起来！”两人于是详细讨论了从哪几样仪器开始，有何难点，甚至如何向执委会要钱要人要物资等等不提。','2018-11-14 22:00:00');
insert into poster(boardid,userid,postertitle,postercontent,postertime)values(6,123,'南朝论坛规则','南朝论坛
本论坛为广收各界信息，促进网友间动漫、文化、历史、自然、科技等文化知识的交流而设立。论坛的主旨是：促进和谐友爱的网络交流，推动文化知识的有序传播。
第2条
为确保和谐、友爱、自由、有序的论坛交流秩序，特制定本论坛规则。
第3条
本论坛的所有注册成员（以下简称“论坛成员”），都平等地受本规则的保护和管理。论坛规则面前，所有论坛成员都是平等的，不因论坛成员在论坛中的任何身份、地位而区别适用。
第4条
论坛成员在论坛中的ID操作权限，由论坛的技术设定确定。
第5条
在不违反宪法、法律、行政法规和本论坛规则的前提下，论坛成员在本论坛中的权利有：
1、在论坛中享有、保持和使用ID的权利。ID是论坛成员在论坛中的身份代表，论坛成员的相关权利通过使用ID的方式行使；
2、自由地进行言论表达的权利。行使该权利的方式包括但不限于：发帖、转帖、回复、点评等；
3、利用论坛提供的相关服务，创建、存储、删除相关个人信息的权利；
4、参与论坛或论坛成员发起组织的各种线下交流活动的权利；
5、论坛成员利用论坛资源进行的知识产权创作，其相关权利由国家相关法律予以保护；
6、参与论坛管理的权利。论坛成员参与论坛的管理，应该依照本论坛规则有序进行；
7、根据各自对论坛的贡献，获得论坛奖励的权利。奖励的形式和级别，由论坛另行规定。
第6条
论坛成员在本论坛中的义务有：
1、遵守中华人民共和国宪法、法律和行政法规的规定，不得利用本论坛进行任何违法犯罪行为；
2、遵守论坛规则，遵从论坛管理人员的版务管理；
3、礼貌、和谐、有序地与他人交流；
4、禁止恶意诋毁和攻击论坛、论坛管理人员的正常工作；
5、不得利用论坛资源进行任何包括但不限于宣传网络赚钱、变相传销等涉及经济内容的信息；
6、不得在未经许可的情况下将论坛资源用于商业用途；
7、不得在未经许可的情况下在论坛中发布商业广告及类似信息；
第7条
违反论坛规则的，依照本规则对论坛成员的ID进行相关处理。
第8条
论坛管理人员的ID级别、权限，由论坛的技术设定而确定；
第9条
论坛管理人员包括：论坛的创建者、论坛的法人代表或论坛所属单位的委托管理者、各区版主、巡视版主、刑部成员等；
第10条
论坛管理人员的管理行为，一律依据本规则实施，不得超出本规则明文规定的范围对论坛成员进行管理和处罚；
第二章：论坛刑名第1条
论坛的处罚分三种：删帖、禁言、封闭用户。
第2条
删帖处罚，处罚方式为删除论坛成员的违规发帖、回复；
第3条
禁言处罚，处罚方式为剥夺论坛成员一定期间内在论坛中发表言论的权利。禁言处罚分三等：禁言1天，禁言3天，禁言7天。
第4条
封闭用户处罚，处罚方式为封闭论坛成员的违规ID。
第5条
论坛成员在论坛中不得进行破坏论题主旨的行为，否则受删帖或禁言处罚。这些行为包括：
1、在讨论中造谣滋事、故意宣传虚假信息的；
2、在讨论中发表与主题无关的商业信息、广告信息的；
3、在讨论中发布违反人类良知的信息的；
4、恶意灌水、刷屏的；5、其他破坏论题主旨的行为。
第6条
论坛成员在论坛中不得扰乱正常的论坛秩序，否则受禁言处罚。这些行为包括：
1、在讨论中攻击、侮辱其他论坛成员人格的；
2、在讨论中挑动地域纷争的；
3、在讨论中发表传销等非法经营信息的；
4、在讨论中发表色情、淫秽信息的；
5、以大量灌水帖刷版的；
6、其他扰乱正常论坛秩序的行为。
第7条
论坛成员在论坛中不得进行违反宪法、法律和相关国家政策的行为，也不得进行严重扰乱论坛秩序、危害论坛安全的行为，否则受封闭用户处罚。这些行为包括：1、发表反对四项基本原则言论的，具体包括：
（1）攻击社会主义制度的言论；
（2）攻击人民民主专政的言论；
（3）攻击中国共产党的言论；
（4）攻击马列主义、毛泽东思想和党的其他指导思想的言论；
（5）以侮辱性词汇称呼国家领导人；
2、发表危害国家安全、鼓吹国家分裂言论的；
3、发表其他动摇国家根本宪法秩序言论的；
4、发表泄露国家机密信息的；
5、发表煽动社会动乱、民族仇恨、种族仇恨言论的，包括但不限于：
（1）煽动破坏社会安定秩序的言论；
（2）宣传民族仇恨思想和极端民族主义思想；
（3）宣传种族仇恨思想和极端种族主义思想；
（4）宣传宗教仇恨思想和极端宗教思想；
（5）鼓吹、赞美法西斯主义的言论；
（6）鼓吹、赞美恐怖主义的言论；
6、发表宣传邪教、封建迷信等有害信息的；
7、发表从事犯罪、教唆他人从事犯罪言论的；
8、以任何手段威胁论坛安全的；
9、以任何手段威胁论坛成员人身、财产和其他合法权利安全的；
10、违反第5条规定5次以上、第6条规定3次以上，屡教不改的','2018-11-14 22:00:00');
insert into reply(posterid,userid,replycontent,replytime)values(1,123,'新话
言语者，喉舌也。世所言髡官职不同故宋，以疑其非宋社稷，以夷变夏。此大谬也！自唐虞来，世间言语变化，不能尽谈。以故宋论，康王南渡，余杭吴侬变作汴京官话。澳洲所用言语，又不同于行在，名为新话。但凡澳学，皆用新话。先辈云：西京之文实，东京之文弱，犹未离实也。六朝之文游，离实矣。唐之文庸，犹未离浮也。宋之文陋，离浮矣，愈下矣。元无文。今新话全以为实，更胜唐宋八大家也。行文往来，风靡仕途。昔仓颉造字，鬼夜哭、天雨粟，因造化之机尽泄。今公安之徒，如张岱辈，皆枉作啾啾，著《陶庵梦忆》、《夜航船》而发怨望，此辈能由新话之行，明科举之衰徵，察文脉之将枯。亦一时文才，奈何新话曰：历史的车轮是不可阻挡的。时也命也，呜呼奈何。
金庸古龙
世俗风行小说，最上为金庸古龙。此二者皆澳洲首长笔名。首长著《天龙八部》一本，言北宋时事，《射神倚》三卷，言先宋之衰、蒙古之祸、朱明之兴，共一百年间事。其中多有与国史不合者，于朱洪武驱无忌、夺明教尤甚。或曰，此举为剥夺前朝驱逐鞑虏合法性。
髡人符章
髡人性淫，旗号非龙非虎，非神非佛，曰铁拳爆菊，龙阳典也。
髡人自造伪朝玺印，非金非玉，乃以精钢秘法铸就，万年不锈，水火不侵。真髡束印于腰间，每用印，辄解裩以示之。真髡不立妻妾，皆广蓄狡童妖女，称秘书，昼间掌印，夜间伴寝，极为亲信。','2018-11-14 22:00:00');

select * from user;
select * from administrator;
select * from poster;
select * from poster order by boardid,seqnum,postertime;

update poster set seqnum=0;
SET SQL_SAFE_UPDATES = 0;