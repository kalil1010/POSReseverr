package net.p003sf.scuba.data;

import java.io.Serializable;

/* loaded from: classes.dex */
public class ISOCountry extends Country implements Serializable {
    private static final Country[] VALUES;

    /* renamed from: ZW */
    public static final Country f585ZW;
    private static final long serialVersionUID = 7220597933847617859L;
    private String alpha2Code;
    private String alpha3Code;
    private int code;
    private String name;
    private String nationality;

    /* renamed from: AD */
    public static final Country f340AD = new ISOCountry(32, "AD", "AND", "Andorra", "Andorran");

    /* renamed from: AE */
    public static final Country f341AE = new ISOCountry(1924, "AE", "ARE", "United Arab Emirates", "Emirati, Emirian");

    /* renamed from: AF */
    public static final Country f342AF = new ISOCountry(4, "AF", "AFG", "Afghanistan", "Afghan");

    /* renamed from: AG */
    public static final Country f343AG = new ISOCountry(40, "AG", "ATG", "Antigua and Barbuda", "Antiguan, Barbudan");

    /* renamed from: AI */
    public static final Country f344AI = new ISOCountry(1632, "AI", "AIA", "Anguilla", "Anguillan");

    /* renamed from: AL */
    public static final Country f345AL = new ISOCountry(8, "AL", "ALB", "Albania", "Albanian");

    /* renamed from: AM */
    public static final Country f346AM = new ISOCountry(81, "AM", "ARM", "Armenia", "Armenian");

    /* renamed from: AN */
    public static final Country f347AN = new ISOCountry(1328, "AN", "ANT", "Netherlands Antilles", "Antillean");

    /* renamed from: AO */
    public static final Country f348AO = new ISOCountry(36, "AO", "AGO", "Angola", "Angolan");

    /* renamed from: AQ */
    public static final Country f349AQ = new ISOCountry(16, "AQ", "ATA", "Antarctica", "Antarctic");

    /* renamed from: AR */
    public static final Country f350AR = new ISOCountry(50, "AR", "ARG", "Argentina", "Argentine, Argentinean, Argentinian");

    /* renamed from: AS */
    public static final Country f351AS = new ISOCountry(22, "AS", "ASM", "American Samoa", "American Samoan");

    /* renamed from: AT */
    public static final Country f352AT = new ISOCountry(64, "AT", "AUT", "Austria", "Austrian");

    /* renamed from: AU */
    public static final Country f353AU = new ISOCountry(54, "AU", "AUS", "Australia", "Australian");

    /* renamed from: AW */
    public static final Country f354AW = new ISOCountry(1331, "AW", "ABW", "Aruba", "Aruban");

    /* renamed from: AX */
    public static final Country f355AX = new ISOCountry(584, "AX", "ALA", "Aland Islands");

    /* renamed from: AZ */
    public static final Country f356AZ = new ISOCountry(49, "AZ", "AZE", "Azerbaijan", "Azerbaijani, Azeri");

    /* renamed from: BA */
    public static final Country f357BA = new ISOCountry(112, "BA", "BIH", "Bosnia and Herzegovina", "Bosnian, Bosniak, Herzegovinian");

    /* renamed from: BB */
    public static final Country f358BB = new ISOCountry(82, "BB", "BRB", "Barbados", "Barbadian");

    /* renamed from: BD */
    public static final Country f359BD = new ISOCountry(80, "BD", "BGD", "Bangladesh", "Bangladeshi");

    /* renamed from: BE */
    public static final Country f360BE = new ISOCountry(86, "BE", "BEL", "Belgium", "Belgian");

    /* renamed from: BF */
    public static final Country f361BF = new ISOCountry(2132, "BF", "BFA", "Burkina Faso", "Burkinabe");

    /* renamed from: BG */
    public static final Country f362BG = new ISOCountry(256, "BG", "BGR", "Bulgaria", "Bulgarian");

    /* renamed from: BH */
    public static final Country f363BH = new ISOCountry(72, "BH", "BHR", "Bahrain", "Bahraini");

    /* renamed from: BI */
    public static final Country f364BI = new ISOCountry(264, "BI", "BDI", "Burundi", "Burundian");

    /* renamed from: BJ */
    public static final Country f365BJ = new ISOCountry(516, "BJ", "BEN", "Benin", "Beninese");

    /* renamed from: BL */
    public static final Country f366BL = new ISOCountry(1618, "BL", "BLM", "Saint Barthlemy");

    /* renamed from: BM */
    public static final Country f367BM = new ISOCountry(96, "BM", "BMU", "Bermuda", "Bermudian, Bermudan");

    /* renamed from: BN */
    public static final Country f368BN = new ISOCountry(150, "BN", "BRN", "Brunei Darussalam", "Bruneian");

    /* renamed from: BO */
    public static final Country f369BO = new ISOCountry(104, "BO", "BOL", "Bolivia", "Bolivian");

    /* renamed from: BR */
    public static final Country f370BR = new ISOCountry(118, "BR", "BRA", "Brazil", "Brazilian");

    /* renamed from: BS */
    public static final Country f371BS = new ISOCountry(68, "BS", "BHS", "Bahamas", "Bahamian");

    /* renamed from: BT */
    public static final Country f372BT = new ISOCountry(100, "BT", "BTN", "Bhutan", "Bhutanese");

    /* renamed from: BV */
    public static final Country f373BV = new ISOCountry(116, "BV", "BVT", "Bouvet Island");

    /* renamed from: BW */
    public static final Country f374BW = new ISOCountry(114, "BW", "BWA", "Botswana", "Botswanan");

    /* renamed from: BY */
    public static final Country f375BY = new ISOCountry(274, "BY", "BLR", "Belarus", "Belarusian");

    /* renamed from: BZ */
    public static final Country f376BZ = new ISOCountry(132, "BZ", "BLZ", "Belize", "Belizean");

    /* renamed from: CA */
    public static final Country f377CA = new ISOCountry(292, "CA", "CAN", "Canada", "Canadian");

    /* renamed from: CC */
    public static final Country f378CC = new ISOCountry(358, "CC", "CCK", "Cocos (Keeling) Islands");

    /* renamed from: CD */
    public static final Country f379CD = new ISOCountry(384, "CD", "COD", "Congo the Democratic Republic of the", "Congolese");

    /* renamed from: CF */
    public static final Country f380CF = new ISOCountry(320, "CF", "CAF", "Central African Republic", "Central African");

    /* renamed from: CG */
    public static final Country f381CG = new ISOCountry(376, "CG", "COG", "Congo", "Congolese");

    /* renamed from: CH */
    public static final Country f382CH = new ISOCountry(1878, "CH", "CHE", "Switzerland", "Swiss");

    /* renamed from: CI */
    public static final Country f383CI = new ISOCountry(900, "CI", "CIV", "Cote d'Ivoire", "Ivorian");

    /* renamed from: CK */
    public static final Country f384CK = new ISOCountry(388, "CK", "COK", "Cook Islands");

    /* renamed from: CL */
    public static final Country f385CL = new ISOCountry(338, "CL", "CHL", "Chile", "Chilean");

    /* renamed from: CM */
    public static final Country f386CM = new ISOCountry(288, "CM", "CMR", "Cameroon", "Cameroonian");

    /* renamed from: CN */
    public static final Country f387CN = new ISOCountry(342, "CN", "CHN", "China", "Chinese");

    /* renamed from: CO */
    public static final Country f388CO = new ISOCountry(368, "CO", "COL", "Colombia", "Colombian");

    /* renamed from: CR */
    public static final Country f389CR = new ISOCountry(392, "CR", "CRI", "Costa Rica", "Costa Rican");

    /* renamed from: CU */
    public static final Country f390CU = new ISOCountry(402, "CU", "CUB", "Cuba", "Cuban");

    /* renamed from: CV */
    public static final Country f391CV = new ISOCountry(306, "CV", "CPV", "Cape Verde", "Cape Verdean");

    /* renamed from: CX */
    public static final Country f392CX = new ISOCountry(354, "CX", "CXR", "Christmas Island");

    /* renamed from: CY */
    public static final Country f393CY = new ISOCountry(406, "CY", "CYP", "Cyprus", "Cypriot");

    /* renamed from: CZ */
    public static final Country f394CZ = new ISOCountry(515, "CZ", "CZE", "Czech Republic", "Czech");

    /* renamed from: DE */
    public static final Country f395DE = new ISOCountry(630, "DE", "DEU", "Germany", "German");

    /* renamed from: DJ */
    public static final Country f396DJ = new ISOCountry(610, "DJ", "DJI", "Djibouti", "Djiboutian");

    /* renamed from: DK */
    public static final Country f397DK = new ISOCountry(520, "DK", "DNK", "Denmark", "Danish");

    /* renamed from: DM */
    public static final Country f398DM = new ISOCountry(530, "DM", "DMA", "Dominica", "Dominican");

    /* renamed from: DO */
    public static final Country f399DO = new ISOCountry(532, "DO", "DOM", "Dominican Republic", "Dominican");

    /* renamed from: DZ */
    public static final Country f400DZ = new ISOCountry(18, "DZ", "DZA", "Algeria", "Algerian");

    /* renamed from: EC */
    public static final Country f401EC = new ISOCountry(536, "EC", "ECU", "Ecuador", "Ecuadorian");

    /* renamed from: EE */
    public static final Country f402EE = new ISOCountry(563, "EE", "EST", "Estonia", "Estonian");

    /* renamed from: EG */
    public static final Country f403EG = new ISOCountry(2072, "EG", "EGY", "Egypt", "Egyptian");

    /* renamed from: EH */
    public static final Country f404EH = new ISOCountry(1842, "EH", "ESH", "Western Sahara", "Sahraw, Sahrawian, Sahraouian");

    /* renamed from: ER */
    public static final Country f405ER = new ISOCountry(562, "ER", "ERI", "Eritrea", "Eritrean");

    /* renamed from: ES */
    public static final Country f406ES = new ISOCountry(1828, "ES", "ESP", "Spain", "Spanish");

    /* renamed from: ET */
    public static final Country f407ET = new ISOCountry(561, "ET", "ETH", "Ethiopia", "Ethiopian");

    /* renamed from: FI */
    public static final Country f408FI = new ISOCountry(582, "FI", "FIN", "Finland", "Finnish");

    /* renamed from: FJ */
    public static final Country f409FJ = new ISOCountry(578, "FJ", "FJI", "Fiji", "Fijian");

    /* renamed from: FK */
    public static final Country f410FK = new ISOCountry(568, "FK", "FLK", "Falkland Islands (Malvinas)");

    /* renamed from: FM */
    public static final Country f411FM = new ISOCountry(1411, "FM", "FSM", "Micronesia Federated States of", "Micronesian");

    /* renamed from: FO */
    public static final Country f412FO = new ISOCountry(564, "FO", "FRO", "Faroe Islands", "Faroese");

    /* renamed from: FR */
    public static final Country f413FR = new ISOCountry(592, "FR", "FRA", "France", "French");

    /* renamed from: GA */
    public static final Country f414GA = new ISOCountry(614, "GA", "GAB", "Gabon", "Gabonese");

    /* renamed from: GB */
    public static final Country f415GB = new ISOCountry(2086, "GB", "GBR", "United Kingdom", "British");

    /* renamed from: GD */
    public static final Country f416GD = new ISOCountry(776, "GD", "GRD", "Grenada", "Grenadian");

    /* renamed from: GE */
    public static final Country f417GE = new ISOCountry(616, "GE", "GEO", "Georgia", "Georgian");

    /* renamed from: GF */
    public static final Country f418GF = new ISOCountry(596, "GF", "GUF", "French Guiana", "French Guianese");

    /* renamed from: GG */
    public static final Country f419GG = new ISOCountry(2097, "GG", "GGY", "Guernsey");

    /* renamed from: GH */
    public static final Country f420GH = new ISOCountry(648, "GH", "GHA", "Ghana", "Ghanaian");

    /* renamed from: GI */
    public static final Country f421GI = new ISOCountry(658, "GI", "GIB", "Gibraltar");

    /* renamed from: GL */
    public static final Country f422GL = new ISOCountry(772, "GL", "GRL", "Greenland", "Greenlandic");

    /* renamed from: GM */
    public static final Country f423GM = new ISOCountry(624, "GM", "GMB", "Gambia", "Gambian");

    /* renamed from: GN */
    public static final Country f424GN = new ISOCountry(804, "GN", "GIN", "Guinea", "Guinean");

    /* renamed from: GP */
    public static final Country f425GP = new ISOCountry(786, "GP", "GLP", "Guadeloupe");

    /* renamed from: GQ */
    public static final Country f426GQ = new ISOCountry(550, "GQ", "GNQ", "Equatorial Guinea", "Equatorial Guinean, Equatoguinean");

    /* renamed from: GR */
    public static final Country f427GR = new ISOCountry(768, "GR", "GRC", "Greece", "Greek, Hellenic");

    /* renamed from: GS */
    public static final Country f428GS = new ISOCountry(569, "GS", "SGS", "South Georgia and the South Sandwich Islands");

    /* renamed from: GT */
    public static final Country f429GT = new ISOCountry(800, "GT", "GTM", "Guatemala", "Guatemalan");

    /* renamed from: GU */
    public static final Country f430GU = new ISOCountry(790, "GU", "GUM", "Guam", "Guamanian");

    /* renamed from: GW */
    public static final Country f431GW = new ISOCountry(1572, "GW", "GNB", "Guinea-Bissau", "Guinean");

    /* renamed from: GY */
    public static final Country f432GY = new ISOCountry(808, "GY", "GUY", "Guyana", "Guyanese");

    /* renamed from: HK */
    public static final Country f433HK = new ISOCountry(836, "HK", "HKG", "Hong Kong", "Hong Kong, Hongkongese");

    /* renamed from: HM */
    public static final Country f434HM = new ISOCountry(820, "HM", "HMD", "Heard Island and McDonald Islands");

    /* renamed from: HN */
    public static final Country f435HN = new ISOCountry(832, "HN", "HND", "Honduras", "Honduran");

    /* renamed from: HR */
    public static final Country f436HR = new ISOCountry(401, "HR", "HRV", "Croatia", "Croatian");

    /* renamed from: HT */
    public static final Country f437HT = new ISOCountry(818, "HT", "HTI", "Haiti", "Haitian");

    /* renamed from: HU */
    public static final Country f438HU = new ISOCountry(840, "HU", "HUN", "Hungary", "Hungarian");

    /* renamed from: ID */
    public static final Country f439ID = new ISOCountry(864, "ID", "IDN", "Indonesia", "Indonesian");

    /* renamed from: IE */
    public static final Country f440IE = new ISOCountry(882, "IE", "IRL", "Ireland", "Irish");

    /* renamed from: IL */
    public static final Country f441IL = new ISOCountry(886, "IL", "ISR", "Israel", "Israeli");

    /* renamed from: IM */
    public static final Country f442IM = new ISOCountry(2099, "IM", "IMN", "Isle of Man", "Manx");

    /* renamed from: IN */
    public static final Country f443IN = new ISOCountry(854, "IN", "IND", "India", "Indian");

    /* renamed from: IO */
    public static final Country f444IO = new ISOCountry(134, "IO", "IOT", "British Indian Ocean Territory");

    /* renamed from: IQ */
    public static final Country f445IQ = new ISOCountry(872, "IQ", "IRQ", "Iraq", "Iraqi");

    /* renamed from: IR */
    public static final Country f446IR = new ISOCountry(868, "IR", "IRN", "Iran Islamic Republic of", "Iranian, Persian");

    /* renamed from: IS */
    public static final Country f447IS = new ISOCountry(850, "IS", "ISL", "Iceland", "Icelandic");

    /* renamed from: IT */
    public static final Country f448IT = new ISOCountry(896, "IT", "ITA", "Italy", "Italian");

    /* renamed from: JE */
    public static final Country f449JE = new ISOCountry(2098, "JE", "JEY", "Jersey");

    /* renamed from: JM */
    public static final Country f450JM = new ISOCountry(904, "JM", "JAM", "Jamaica", "Jamaican");

    /* renamed from: JO */
    public static final Country f451JO = new ISOCountry(1024, "JO", "JOR", "Jordan", "Jordanian");

    /* renamed from: JP */
    public static final Country f452JP = new ISOCountry(914, "JP", "JPN", "Japan", "Japanese");

    /* renamed from: KE */
    public static final Country f453KE = new ISOCountry(1028, "KE", "KEN", "Kenya", "Kenyan");

    /* renamed from: KG */
    public static final Country f454KG = new ISOCountry(1047, "KG", "KGZ", "Kyrgyzstan", "Kyrgyz");

    /* renamed from: KH */
    public static final Country f455KH = new ISOCountry(278, "KH", "KHM", "Cambodia", "Cambodian");

    /* renamed from: KI */
    public static final Country f456KI = new ISOCountry(662, "KI", "KIR", "Kiribati", "I-Kiribati");

    /* renamed from: KM */
    public static final Country f457KM = new ISOCountry(372, "KM", "COM", "Comoros", "Comorian");

    /* renamed from: KN */
    public static final Country f458KN = new ISOCountry(1625, "KN", "KNA", "Saint Kitts and Nevis");

    /* renamed from: KP */
    public static final Country f459KP = new ISOCountry(1032, "KP", "PRK", "Korea Democratic People's Republic of", "North Korean");

    /* renamed from: KR */
    public static final Country f460KR = new ISOCountry(1040, "KR", "KOR", "Korea Republic of", "South Korean");

    /* renamed from: KW */
    public static final Country f461KW = new ISOCountry(1044, "KW", "KWT", "Kuwait", "Kuwaiti");

    /* renamed from: KY */
    public static final Country f462KY = new ISOCountry(310, "KY", "CYM", "Cayman Islands", "Caymanian");

    /* renamed from: KZ */
    public static final Country f463KZ = new ISOCountry(920, "KZ", "KAZ", "Kazakhstan", "Kazakh");

    /* renamed from: LA */
    public static final Country f464LA = new ISOCountry(1048, "LA", "LAO", "Lao People's Democratic Republic", "Lao");

    /* renamed from: LB */
    public static final Country f465LB = new ISOCountry(1058, "LB", "LBN", "Lebanon", "Lebanese");

    /* renamed from: LC */
    public static final Country f466LC = new ISOCountry(1634, "LC", "LCA", "Saint Lucia", "Saint Lucian");

    /* renamed from: LI */
    public static final Country f467LI = new ISOCountry(1080, "LI", "LIE", "Liechtenstein");

    /* renamed from: LK */
    public static final Country f468LK = new ISOCountry(324, "LK", "LKA", "Sri Lanka", "Sri Lankan");

    /* renamed from: LR */
    public static final Country f469LR = new ISOCountry(1072, "LR", "LBR", "Liberia", "Liberian");

    /* renamed from: LS */
    public static final Country f470LS = new ISOCountry(1062, "LS", "LSO", "Lesotho", "Basotho");

    /* renamed from: LT */
    public static final Country f471LT = new ISOCountry(1088, "LT", "LTU", "Lithuania", "Lithuanian");

    /* renamed from: LU */
    public static final Country f472LU = new ISOCountry(1090, "LU", "LUX", "Luxembourg", "Luxembourg, Luxembourgish");

    /* renamed from: LV */
    public static final Country f473LV = new ISOCountry(1064, "LV", "LVA", "Latvia", "Latvian");

    /* renamed from: LY */
    public static final Country f474LY = new ISOCountry(1076, "LY", "LBY", "Libyan Arab Jamahiriya", "Libyan");

    /* renamed from: MA */
    public static final Country f475MA = new ISOCountry(1284, "MA", "MAR", "Morocco", "Moroccan");

    /* renamed from: MC */
    public static final Country f476MC = new ISOCountry(1170, "MC", "MCO", "Monaco", "Monegasque, Monacan");

    /* renamed from: MD */
    public static final Country f477MD = new ISOCountry(1176, "MD", "MDA", "Moldova", "Moldovan");

    /* renamed from: ME */
    public static final Country f478ME = new ISOCountry(1177, "ME", "MNE", "Montenegro", "Montenegrin");

    /* renamed from: MF */
    public static final Country f479MF = new ISOCountry(1635, "MF", "MAF", "Saint Martin (French part)");

    /* renamed from: MG */
    public static final Country f480MG = new ISOCountry(1104, "MG", "MDG", "Madagascar", "Malagasy");

    /* renamed from: MH */
    public static final Country f481MH = new ISOCountry(1412, "MH", "MHL", "Marshall Islands", "Marshallese");

    /* renamed from: MK */
    public static final Country f482MK = new ISOCountry(2055, "MK", "MKD", "Macedonia the former Yugoslav Republic of", "Macedonian");

    /* renamed from: ML */
    public static final Country f483ML = new ISOCountry(1126, "ML", "MLI", "Mali", "Malian");

    /* renamed from: MM */
    public static final Country f484MM = new ISOCountry(260, "MM", "MMR", "Myanmar", "Burmese");

    /* renamed from: MN */
    public static final Country f485MN = new ISOCountry(1174, "MN", "MNG", "Mongolia", "Mongolian");

    /* renamed from: MO */
    public static final Country f486MO = new ISOCountry(1094, "MO", "MAC", "Macao", "Macanese, Chinese");

    /* renamed from: MP */
    public static final Country f487MP = new ISOCountry(1408, "MP", "MNP", "Northern Mariana Islands", "Northern Marianan");

    /* renamed from: MQ */
    public static final Country f488MQ = new ISOCountry(1140, "MQ", "MTQ", "Martinique", "Martiniquais, Martinican");

    /* renamed from: MR */
    public static final Country f489MR = new ISOCountry(1144, "MR", "MRT", "Mauritania", "Mauritanian");

    /* renamed from: MS */
    public static final Country f490MS = new ISOCountry(1280, "MS", "MSR", "Montserrat", "Montserratian");

    /* renamed from: MT */
    public static final Country f491MT = new ISOCountry(1136, "MT", "MLT", "Malta", "Maltese");

    /* renamed from: MU */
    public static final Country f492MU = new ISOCountry(1152, "MU", "MUS", "Mauritius", "Mauritian");

    /* renamed from: MV */
    public static final Country f493MV = new ISOCountry(1122, "MV", "MDV", "Maldives", "Maldivian");

    /* renamed from: MW */
    public static final Country f494MW = new ISOCountry(1108, "MW", "MWI", "Malawi", "Malawian");

    /* renamed from: MX */
    public static final Country f495MX = new ISOCountry(1156, "MX", "MEX", "Mexico", "Mexican");

    /* renamed from: MY */
    public static final Country f496MY = new ISOCountry(1112, "MY", "MYS", "Malaysia", "Malaysian");

    /* renamed from: MZ */
    public static final Country f497MZ = new ISOCountry(1288, "MZ", "MOZ", "Mozambique", "Mozambican");

    /* renamed from: NA */
    public static final Country f498NA = new ISOCountry(1302, "NA", "NAM", "Namibia", "Namibian");

    /* renamed from: NC */
    public static final Country f499NC = new ISOCountry(1344, "NC", "NCL", "New Caledonia", "New Caledonian");

    /* renamed from: NE */
    public static final Country f500NE = new ISOCountry(1378, "NE", "NER", "Niger", "Nigerien");

    /* renamed from: NF */
    public static final Country f501NF = new ISOCountry(1396, "NF", "NFK", "Norfolk Island");

    /* renamed from: NG */
    public static final Country f502NG = new ISOCountry(1382, "NG", "NGA", "Nigeria", "Nigerian");

    /* renamed from: NI */
    public static final Country f503NI = new ISOCountry(1368, "NI", "NIC", "Nicaragua", "Nicaraguan");

    /* renamed from: NL */
    public static final Country f504NL = new ISOCountry(1320, "NL", "NLD", "Netherlands", "Dutch");

    /* renamed from: NO */
    public static final Country f505NO = new ISOCountry(1400, "NO", "NOR", "Norway", "Norwegian");

    /* renamed from: NP */
    public static final Country f506NP = new ISOCountry(1316, "NP", "NPL", "Nepal", "Nepali");

    /* renamed from: NR */
    public static final Country f507NR = new ISOCountry(1312, "NR", "NRU", "Nauru", "Nauruan");

    /* renamed from: NU */
    public static final Country f508NU = new ISOCountry(1392, "NU", "NIU", "Niue", "Niuean");

    /* renamed from: NZ */
    public static final Country f509NZ = new ISOCountry(1364, "NZ", "NZL", "New Zealand");

    /* renamed from: OM */
    public static final Country f510OM = new ISOCountry(1298, "OM", "OMN", "Oman", "Omani");

    /* renamed from: PA */
    public static final Country f511PA = new ISOCountry(1425, "PA", "PAN", "Panama", "Panamanian");

    /* renamed from: PE */
    public static final Country f512PE = new ISOCountry(1540, "PE", "PER", "Peru", "Peruvian");

    /* renamed from: PF */
    public static final Country f513PF = new ISOCountry(600, "PF", "PYF", "French Polynesia", "French Polynesian");

    /* renamed from: PG */
    public static final Country f514PG = new ISOCountry(1432, "PG", "PNG", "Papua New Guinea", "Papua New Guinean, Papuan");

    /* renamed from: PH */
    public static final Country f515PH = new ISOCountry(1544, "PH", "PHL", "Philippines", "Philippine, Filipino");

    /* renamed from: PK */
    public static final Country f516PK = new ISOCountry(1414, "PK", "PAK", "Pakistan", "Pakistani");

    /* renamed from: PL */
    public static final Country f517PL = new ISOCountry(1558, "PL", "POL", "Poland", "Polish");

    /* renamed from: PM */
    public static final Country f518PM = new ISOCountry(1638, "PM", "SPM", "Saint Pierre and Miquelon", "Saint Pierrais, Miquelonnais");

    /* renamed from: PN */
    public static final Country f519PN = new ISOCountry(1554, "PN", "PCN", "Pitcairn");

    /* renamed from: PR */
    public static final Country f520PR = new ISOCountry(1584, "PR", "PRI", "Puerto Rico", "Puerto Rican");

    /* renamed from: PS */
    public static final Country f521PS = new ISOCountry(629, "PS", "PSE", "Palestinian Territory Occupied", "Palestinian");

    /* renamed from: PT */
    public static final Country f522PT = new ISOCountry(1568, "PT", "PRT", "Portugal", "Portuguese");

    /* renamed from: PW */
    public static final Country f523PW = new ISOCountry(1413, "PW", "PLW", "Palau", "Palauan");

    /* renamed from: PY */
    public static final Country f524PY = new ISOCountry(1536, "PY", "PRY", "Paraguay", "Paraguayan");

    /* renamed from: QA */
    public static final Country f525QA = new ISOCountry(1588, "QA", "QAT", "Qatar", "Qatari");

    /* renamed from: RE */
    public static final Country f526RE = new ISOCountry(1592, "RE", "REU", "Reunion", "Reunionese, Reunionnais");

    /* renamed from: RO */
    public static final Country f527RO = new ISOCountry(1602, "RO", "ROU", "Romania", "Romanian");

    /* renamed from: RS */
    public static final Country f528RS = new ISOCountry(1672, "RS", "SRB", "Serbia", "Serbian");

    /* renamed from: RU */
    public static final Country f529RU = new ISOCountry(1603, "RU", "RUS", "Russian Federation", "Russian");

    /* renamed from: RW */
    public static final Country f530RW = new ISOCountry(1606, "RW", "RWA", "Rwanda", "Rwandan");

    /* renamed from: SA */
    public static final Country f531SA = new ISOCountry(1666, "SA", "SAU", "Saudi Arabia", "Saudi, Saudi Arabian");

    /* renamed from: SB */
    public static final Country f532SB = new ISOCountry(144, "SB", "SLB", "Solomon Islands", "Solomon Island");

    /* renamed from: SC */
    public static final Country f533SC = new ISOCountry(1680, "SC", "SYC", "Seychelles", "Seychellois");

    /* renamed from: SD */
    public static final Country f534SD = new ISOCountry(1846, "SD", "SDN", "Sudan", "Sudanese");

    /* renamed from: SE */
    public static final Country f535SE = new ISOCountry(1874, "SE", "SWE", "Sweden", "Swedish");

    /* renamed from: SG */
    public static final Country f536SG = new ISOCountry(1794, "SG", "SGP", "Singapore");

    /* renamed from: SH */
    public static final Country f537SH = new ISOCountry(1620, "SH", "SHN", "Saint Helena", "Saint Helenian");

    /* renamed from: SI */
    public static final Country f538SI = new ISOCountry(1797, "SI", "SVN", "Slovenia", "Slovenian, Slovene");

    /* renamed from: SJ */
    public static final Country f539SJ = new ISOCountry(1860, "SJ", "SJM", "Svalbard and Jan Mayen");

    /* renamed from: SK */
    public static final Country f540SK = new ISOCountry(1795, "SK", "SVK", "Slovakia", "Slovak");

    /* renamed from: SL */
    public static final Country f541SL = new ISOCountry(1684, "SL", "SLE", "Sierra Leone", "Sierra Leonean");

    /* renamed from: SM */
    public static final Country f542SM = new ISOCountry(1652, "SM", "SMR", "San Marino", "Sammarinese");

    /* renamed from: SN */
    public static final Country f543SN = new ISOCountry(1670, "SN", "SEN", "Senegal", "Senegalese");

    /* renamed from: SO */
    public static final Country f544SO = new ISOCountry(1798, "SO", "SOM", "Somalia", "Somali, Somalian");

    /* renamed from: SR */
    public static final Country f545SR = new ISOCountry(1856, "SR", "SUR", "Suriname", "Surinamese");

    /* renamed from: ST */
    public static final Country f546ST = new ISOCountry(1656, "ST", "STP", "Sao Tome and Principe", "Sao Tomean");

    /* renamed from: SV */
    public static final Country f547SV = new ISOCountry(546, "SV", "SLV", "El Salvador", "Salvadoran");

    /* renamed from: SY */
    public static final Country f548SY = new ISOCountry(1888, "SY", "SYR", "Syrian Arab Republic", "Syrian");

    /* renamed from: SZ */
    public static final Country f549SZ = new ISOCountry(1864, "SZ", "SWZ", "Swaziland", "Swazi");

    /* renamed from: TC */
    public static final Country f550TC = new ISOCountry(1942, "TC", "TCA", "Turks and Caicos Islands");

    /* renamed from: TD */
    public static final Country f551TD = new ISOCountry(328, "TD", "TCD", "Chad", "Chadian");

    /* renamed from: TF */
    public static final Country f552TF = new ISOCountry(608, "TF", "ATF", "French Southern Territories");

    /* renamed from: TG */
    public static final Country f553TG = new ISOCountry(1896, "TG", "TGO", "Togo", "Togolese");

    /* renamed from: TH */
    public static final Country f554TH = new ISOCountry(1892, "TH", "THA", "Thailand", "Thai");

    /* renamed from: TJ */
    public static final Country f555TJ = new ISOCountry(1890, "TJ", "TJK", "Tajikistan", "Tajikistani");

    /* renamed from: TK */
    public static final Country f556TK = new ISOCountry(1906, "TK", "TKL", "Tokelau");

    /* renamed from: TL */
    public static final Country f557TL = new ISOCountry(1574, "TL", "TLS", "Timor-Leste", "Timorese");

    /* renamed from: TM */
    public static final Country f558TM = new ISOCountry(1941, "TM", "TKM", "Turkmenistan", "Turkmen");

    /* renamed from: TN */
    public static final Country f559TN = new ISOCountry(1928, "TN", "TUN", "Tunisia", "Tunisian");

    /* renamed from: TO */
    public static final Country f560TO = new ISOCountry(1910, "TO", "TON", "Tonga", "Tongan");

    /* renamed from: TR */
    public static final Country f561TR = new ISOCountry(1938, "TR", "TUR", "Turkey", "Turkish");

    /* renamed from: TT */
    public static final Country f562TT = new ISOCountry(1920, "TT", "TTO", "Trinidad and Tobago", "Trinidadian, Tobagonian");

    /* renamed from: TV */
    public static final Country f563TV = new ISOCountry(1944, "TV", "TUV", "Tuvalu", "Tuvaluan");

    /* renamed from: TW */
    public static final Country f564TW = new ISOCountry(344, "TW", "TWN", "Taiwan Province of China", "Taiwanese");

    /* renamed from: TZ */
    public static final Country f565TZ = new ISOCountry(2100, "TZ", "TZA", "Tanzania United Republic of", "Tanzanian");

    /* renamed from: UA */
    public static final Country f566UA = new ISOCountry(2052, "UA", "UKR", "Ukraine", "Ukrainian");

    /* renamed from: UG */
    public static final Country f567UG = new ISOCountry(2048, "UG", "UGA", "Uganda", "Ugandan");

    /* renamed from: UM */
    public static final Country f568UM = new ISOCountry(1409, "UM", "UMI", "United States Minor Outlying Islands");

    /* renamed from: US */
    public static final Country f569US = new ISOCountry(2112, "US", "USA", "United States", "American");

    /* renamed from: UY */
    public static final Country f570UY = new ISOCountry(2136, "UY", "URY", "Uruguay", "Uruguayan");

    /* renamed from: UZ */
    public static final Country f571UZ = new ISOCountry(2144, "UZ", "UZB", "Uzbekistan", "Uzbekistani, Uzbek");

    /* renamed from: VA */
    public static final Country f572VA = new ISOCountry(822, "VA", "VAT", "Holy See (Vatican City State)");

    /* renamed from: VC */
    public static final Country f573VC = new ISOCountry(1648, "VC", "VCT", "Saint Vincent and the Grenadines", "Saint Vincentian");

    /* renamed from: VE */
    public static final Country f574VE = new ISOCountry(2146, "VE", "VEN", "Venezuela", "Venezuelan");

    /* renamed from: VG */
    public static final Country f575VG = new ISOCountry(146, "VG", "VGB", "Virgin Islands British", "Virgin Island");

    /* renamed from: VI */
    public static final Country f576VI = new ISOCountry(2128, "VI", "VIR", "Virgin Islands U.S.", "Virgin Island");

    /* renamed from: VN */
    public static final Country f577VN = new ISOCountry(1796, "VN", "VNM", "Viet Nam", "Vietnamese");

    /* renamed from: VU */
    public static final Country f578VU = new ISOCountry(1352, "VU", "VUT", "Vanuatu", "Ni-Vanuatu, Vanuatuan");

    /* renamed from: WF */
    public static final Country f579WF = new ISOCountry(2166, "WF", "WLF", "Wallis and Futuna", "Wallisian, Futunan");

    /* renamed from: WS */
    public static final Country f580WS = new ISOCountry(2178, "WS", "WSM", "Samoa", "Samoan");

    /* renamed from: YE */
    public static final Country f581YE = new ISOCountry(2183, "YE", "YEM", "Yemen", "Yemeni");

    /* renamed from: YT */
    public static final Country f582YT = new ISOCountry(373, "YT", "MYT", "Mayotte", "Mahoran");

    /* renamed from: ZA */
    public static final Country f583ZA = new ISOCountry(1808, "ZA", "ZAF", "South Africa", "South African");

    /* renamed from: ZM */
    public static final Country f584ZM = new ISOCountry(2196, "ZM", "ZMB", "Zambia", "Zambian");

    static {
        ISOCountry iSOCountry = new ISOCountry(1814, "ZW", "ZWE", "Zimbabwe", "Zimbabwean");
        f585ZW = iSOCountry;
        VALUES = new Country[]{f354AW, f342AF, f348AO, f344AI, f355AX, f345AL, f340AD, f347AN, f341AE, f350AR, f346AM, f351AS, f349AQ, f552TF, f343AG, f353AU, f352AT, f356AZ, f364BI, f360BE, f365BJ, f361BF, f359BD, f362BG, f363BH, f371BS, f357BA, f366BL, f375BY, f376BZ, f367BM, f369BO, f370BR, f358BB, f368BN, f372BT, f373BV, f374BW, f380CF, f377CA, f378CC, f382CH, f385CL, f387CN, f383CI, f386CM, f379CD, f381CG, f384CK, f388CO, f457KM, f391CV, f389CR, f390CU, f392CX, f462KY, f393CY, f394CZ, f395DE, f396DJ, f398DM, f397DK, f399DO, f400DZ, f401EC, f403EG, f405ER, f404EH, f406ES, f402EE, f407ET, f408FI, f409FJ, f410FK, f413FR, f412FO, f411FM, f414GA, f415GB, f417GE, f419GG, f420GH, f421GI, f424GN, f425GP, f423GM, f431GW, f426GQ, f427GR, f416GD, f422GL, f429GT, f418GF, f430GU, f432GY, f433HK, f434HM, f435HN, f436HR, f437HT, f438HU, f439ID, f442IM, f443IN, f444IO, f440IE, f446IR, f445IQ, f447IS, f441IL, f448IT, f450JM, f449JE, f451JO, f452JP, f463KZ, f453KE, f454KG, f455KH, f456KI, f458KN, f460KR, f461KW, f464LA, f465LB, f469LR, f474LY, f466LC, f467LI, f468LK, f470LS, f471LT, f472LU, f473LV, f486MO, f479MF, f475MA, f476MC, f477MD, f480MG, f493MV, f495MX, f481MH, f482MK, f483ML, f491MT, f484MM, f478ME, f485MN, f487MP, f497MZ, f489MR, f490MS, f488MQ, f492MU, f494MW, f496MY, f582YT, f498NA, f499NC, f500NE, f501NF, f502NG, f503NI, f508NU, f504NL, f505NO, f506NP, f507NR, f509NZ, f510OM, f516PK, f511PA, f519PN, f512PE, f515PH, f523PW, f514PG, f517PL, f520PR, f459KP, f522PT, f524PY, f521PS, f513PF, f525QA, f526RE, f527RO, f529RU, f530RW, f531SA, f534SD, f543SN, f536SG, f428GS, f537SH, f539SJ, f532SB, f541SL, f547SV, f542SM, f544SO, f518PM, f528RS, f546ST, f545SR, f540SK, f538SI, f535SE, f549SZ, f533SC, f548SY, f550TC, f551TD, f553TG, f554TH, f555TJ, f556TK, f558TM, f557TL, f560TO, f562TT, f559TN, f561TR, f563TV, f564TW, f565TZ, f567UG, f566UA, f568UM, f570UY, f569US, f571UZ, f572VA, f573VC, f574VE, f575VG, f576VI, f577VN, f578VU, f579WF, f580WS, f581YE, f583ZA, f584ZM, iSOCountry};
    }

    private ISOCountry(int code, String alpha2Code, String alpha3Code, String name) {
        this(code, alpha2Code, alpha3Code, name, name);
    }

    private ISOCountry(int code, String alpha2Code, String alpha3Code, String name, String nationality) {
        this.code = code;
        this.alpha2Code = alpha2Code;
        this.alpha3Code = alpha3Code;
        this.name = name;
        this.nationality = nationality;
    }

    public static Country[] values() {
        return VALUES;
    }

    @Override // net.p003sf.scuba.data.Country
    public int valueOf() {
        return this.code;
    }

    @Override // net.p003sf.scuba.data.Country
    public String getName() {
        return this.name;
    }

    @Override // net.p003sf.scuba.data.Country
    public String getNationality() {
        return this.nationality;
    }

    public String toString() {
        return this.alpha2Code;
    }

    @Override // net.p003sf.scuba.data.Country
    public String toAlpha2Code() {
        return this.alpha2Code;
    }

    @Override // net.p003sf.scuba.data.Country
    public String toAlpha3Code() {
        return this.alpha3Code;
    }

    public int hashCode() {
        return this.code;
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        ISOCountry other = (ISOCountry) obj;
        return other.code == this.code;
    }

    public int compareTo(Country o) {
        return toAlpha2Code().compareTo(o.toAlpha2Code());
    }
}
