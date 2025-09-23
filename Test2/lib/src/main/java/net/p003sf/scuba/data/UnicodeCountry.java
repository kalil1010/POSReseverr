package net.p003sf.scuba.data;

import java.io.Serializable;

/* loaded from: classes.dex */
public class UnicodeCountry extends Country implements Serializable {
    private static final Country[] VALUES;

    /* renamed from: ZW */
    public static final Country f834ZW;
    private static final long serialVersionUID = 7220597933847617853L;
    private String alpha2Code;
    private String alpha3Code;
    private int code;
    private String name;
    private String nationality;

    /* renamed from: AD */
    public static final Country f589AD = new UnicodeCountry(32, "AD", "AND", "Andorra", "Andorran");

    /* renamed from: AE */
    public static final Country f590AE = new UnicodeCountry(1924, "AE", "ARE", "United Arab Emirates", "Emirati, Emirian");

    /* renamed from: AF */
    public static final Country f591AF = new UnicodeCountry(4, "AF", "AFG", "Afghanistan", "Afghan");

    /* renamed from: AG */
    public static final Country f592AG = new UnicodeCountry(40, "AG", "ATG", "Antigua and Barbuda", "Antiguan, Barbudan");

    /* renamed from: AI */
    public static final Country f593AI = new UnicodeCountry(1632, "AI", "AIA", "Anguilla", "Anguillan");

    /* renamed from: AL */
    public static final Country f594AL = new UnicodeCountry(8, "AL", "ALB", "Albania", "Albanian");

    /* renamed from: AM */
    public static final Country f595AM = new UnicodeCountry(81, "AM", "ARM", "Armenia", "Armenian");

    /* renamed from: AN */
    public static final Country f596AN = new UnicodeCountry(1328, "AN", "ANT", "Netherlands Antilles", "Antillean");

    /* renamed from: AO */
    public static final Country f597AO = new UnicodeCountry(36, "AO", "AGO", "Angola", "Angolan");

    /* renamed from: AQ */
    public static final Country f598AQ = new UnicodeCountry(16, "AQ", "ATA", "Antarctica", "Antarctic");

    /* renamed from: AR */
    public static final Country f599AR = new UnicodeCountry(50, "AR", "ARG", "Argentina", "Argentine, Argentinean, Argentinian");

    /* renamed from: AS */
    public static final Country f600AS = new UnicodeCountry(22, "AS", "ASM", "American Samoa", "American Samoan");

    /* renamed from: AT */
    public static final Country f601AT = new UnicodeCountry(64, "AT", "AUT", "Austria", "Austrian");

    /* renamed from: AU */
    public static final Country f602AU = new UnicodeCountry(54, "AU", "AUS", "Australia", "Australian");

    /* renamed from: AW */
    public static final Country f603AW = new UnicodeCountry(1331, "AW", "ABW", "Aruba", "Aruban");

    /* renamed from: AX */
    public static final Country f604AX = new UnicodeCountry(584, "AX", "ALA", "Åland Islands", "");

    /* renamed from: AZ */
    public static final Country f605AZ = new UnicodeCountry(49, "AZ", "AZE", "Azerbaijan", "Azerbaijani, Azeri");

    /* renamed from: BA */
    public static final Country f606BA = new UnicodeCountry(112, "BA", "BIH", "Bosnia and Herzegovina", "Bosnian, Bosniak, Herzegovinian");

    /* renamed from: BB */
    public static final Country f607BB = new UnicodeCountry(82, "BB", "BRB", "Barbados", "Barbadian");

    /* renamed from: BD */
    public static final Country f608BD = new UnicodeCountry(80, "BD", "BGD", "Bangladesh", "Bangladeshi");

    /* renamed from: BE */
    public static final Country f609BE = new UnicodeCountry(86, "BE", "BEL", "Belgium", "Belgian");

    /* renamed from: BF */
    public static final Country f610BF = new UnicodeCountry(2132, "BF", "BFA", "Burkina Faso", "Burkinabe");

    /* renamed from: BG */
    public static final Country f611BG = new UnicodeCountry(256, "BG", "BGR", "Bulgaria", "Bulgarian");

    /* renamed from: BH */
    public static final Country f612BH = new UnicodeCountry(72, "BH", "BHR", "Bahrain", "Bahraini");

    /* renamed from: BI */
    public static final Country f613BI = new UnicodeCountry(264, "BI", "BDI", "Burundi", "Burundian");

    /* renamed from: BJ */
    public static final Country f614BJ = new UnicodeCountry(516, "BJ", "BEN", "Benin", "Beninese");

    /* renamed from: BL */
    public static final Country f615BL = new UnicodeCountry(1618, "BL", "BLM", "Saint Barthélemy", "");

    /* renamed from: BM */
    public static final Country f616BM = new UnicodeCountry(96, "BM", "BMU", "Bermuda", "Bermudian, Bermudan");

    /* renamed from: BN */
    public static final Country f617BN = new UnicodeCountry(150, "BN", "BRN", "Brunei", "Bruneian");

    /* renamed from: BO */
    public static final Country f618BO = new UnicodeCountry(104, "BO", "BOL", "Bolivia", "Bolivian");

    /* renamed from: BR */
    public static final Country f619BR = new UnicodeCountry(118, "BR", "BRA", "Brazil", "Brazilian");

    /* renamed from: BS */
    public static final Country f620BS = new UnicodeCountry(68, "BS", "BHS", "Bahamas", "Bahamian");

    /* renamed from: BT */
    public static final Country f621BT = new UnicodeCountry(100, "BT", "BTN", "Bhutan", "Bhutanese");

    /* renamed from: BV */
    public static final Country f622BV = new UnicodeCountry(116, "BV", "BVT", "Bouvet Island", "");

    /* renamed from: BW */
    public static final Country f623BW = new UnicodeCountry(114, "BW", "BWA", "Botswana", "Botswanan");

    /* renamed from: BY */
    public static final Country f624BY = new UnicodeCountry(274, "BY", "BLR", "Belarus", "Belarusian");

    /* renamed from: BZ */
    public static final Country f625BZ = new UnicodeCountry(132, "BZ", "BLZ", "Belize", "Belizean");

    /* renamed from: CA */
    public static final Country f626CA = new UnicodeCountry(292, "CA", "CAN", "Canada", "Canadian");

    /* renamed from: CC */
    public static final Country f627CC = new UnicodeCountry(358, "CC", "CCK", "Cocos [Keeling] Islands", "");

    /* renamed from: CD */
    public static final Country f628CD = new UnicodeCountry(384, "CD", "COD", "Congo - Kinshasa", "Congolese");

    /* renamed from: CF */
    public static final Country f629CF = new UnicodeCountry(320, "CF", "CAF", "Central African Republic", "Central African");

    /* renamed from: CG */
    public static final Country f630CG = new UnicodeCountry(376, "CG", "COG", "Congo - Brazzaville", "Congolese");

    /* renamed from: CH */
    public static final Country f631CH = new UnicodeCountry(1878, "CH", "CHE", "Switzerland", "Swiss");

    /* renamed from: CI */
    public static final Country f632CI = new UnicodeCountry(900, "CI", "CIV", "Côte d’Ivoire", "Ivorian");

    /* renamed from: CK */
    public static final Country f633CK = new UnicodeCountry(388, "CK", "COK", "Cook Islands", "");

    /* renamed from: CL */
    public static final Country f634CL = new UnicodeCountry(338, "CL", "CHL", "Chile", "Chilean");

    /* renamed from: CM */
    public static final Country f635CM = new UnicodeCountry(288, "CM", "CMR", "Cameroon", "Cameroonian");

    /* renamed from: CN */
    public static final Country f636CN = new UnicodeCountry(342, "CN", "CHN", "China", "Chinese");

    /* renamed from: CO */
    public static final Country f637CO = new UnicodeCountry(368, "CO", "COL", "Colombia", "Colombian");

    /* renamed from: CR */
    public static final Country f638CR = new UnicodeCountry(392, "CR", "CRI", "Costa Rica", "Costa Rican");

    /* renamed from: CU */
    public static final Country f639CU = new UnicodeCountry(402, "CU", "CUB", "Cuba", "Cuban");

    /* renamed from: CV */
    public static final Country f640CV = new UnicodeCountry(306, "CV", "CPV", "Cape Verde", "Cape Verdean");

    /* renamed from: CX */
    public static final Country f641CX = new UnicodeCountry(354, "CX", "CXR", "Christmas Island", "");

    /* renamed from: CY */
    public static final Country f642CY = new UnicodeCountry(406, "CY", "CYP", "Cyprus", "Cypriot");

    /* renamed from: CZ */
    public static final Country f643CZ = new UnicodeCountry(515, "CZ", "CZE", "Czech Republic", "Czech");

    /* renamed from: DE */
    public static final Country f644DE = new UnicodeCountry(630, "DE", "DEU", "Germany", "German");

    /* renamed from: DJ */
    public static final Country f645DJ = new UnicodeCountry(610, "DJ", "DJI", "Djibouti", "Djiboutian");

    /* renamed from: DK */
    public static final Country f646DK = new UnicodeCountry(520, "DK", "DNK", "Denmark", "Danish");

    /* renamed from: DM */
    public static final Country f647DM = new UnicodeCountry(530, "DM", "DMA", "Dominica", "Dominican");

    /* renamed from: DO */
    public static final Country f648DO = new UnicodeCountry(532, "DO", "DOM", "Dominican Republic", "Dominican");

    /* renamed from: DZ */
    public static final Country f649DZ = new UnicodeCountry(18, "DZ", "DZA", "Algeria", "Algerian");

    /* renamed from: EC */
    public static final Country f650EC = new UnicodeCountry(536, "EC", "ECU", "Ecuador", "Ecuadorian");

    /* renamed from: EE */
    public static final Country f651EE = new UnicodeCountry(563, "EE", "EST", "Estonia", "Estonian");

    /* renamed from: EG */
    public static final Country f652EG = new UnicodeCountry(2072, "EG", "EGY", "Egypt", "Egyptian");

    /* renamed from: EH */
    public static final Country f653EH = new UnicodeCountry(1842, "EH", "ESH", "Western Sahara", "Sahraw, Sahrawian, Sahraouian");

    /* renamed from: ER */
    public static final Country f654ER = new UnicodeCountry(562, "ER", "ERI", "Eritrea", "Eritrean");

    /* renamed from: ES */
    public static final Country f655ES = new UnicodeCountry(1828, "ES", "ESP", "Spain", "Spanish");

    /* renamed from: ET */
    public static final Country f656ET = new UnicodeCountry(561, "ET", "ETH", "Ethiopia", "Ethiopian");

    /* renamed from: FI */
    public static final Country f657FI = new UnicodeCountry(582, "FI", "FIN", "Finland", "Finnish");

    /* renamed from: FJ */
    public static final Country f658FJ = new UnicodeCountry(578, "FJ", "FJI", "Fiji", "Fijian");

    /* renamed from: FK */
    public static final Country f659FK = new UnicodeCountry(568, "FK", "FLK", "Falkland Islands", "");

    /* renamed from: FM */
    public static final Country f660FM = new UnicodeCountry(1411, "FM", "FSM", "Micronesia", "Micronesian");

    /* renamed from: FO */
    public static final Country f661FO = new UnicodeCountry(564, "FO", "FRO", "Faroe Islands", "Faroese");

    /* renamed from: FR */
    public static final Country f662FR = new UnicodeCountry(592, "FR", "FRA", "France", "French");

    /* renamed from: GA */
    public static final Country f663GA = new UnicodeCountry(614, "GA", "GAB", "Gabon", "Gabonese");

    /* renamed from: GB */
    public static final Country f664GB = new UnicodeCountry(2086, "GB", "GBR", "United Kingdom", "British");

    /* renamed from: GD */
    public static final Country f665GD = new UnicodeCountry(776, "GD", "GRD", "Grenada", "Grenadian");

    /* renamed from: GE */
    public static final Country f666GE = new UnicodeCountry(616, "GE", "GEO", "Georgia", "Georgian");

    /* renamed from: GF */
    public static final Country f667GF = new UnicodeCountry(596, "GF", "GUF", "French Guiana", "French Guianese");

    /* renamed from: GG */
    public static final Country f668GG = new UnicodeCountry(2097, "GG", "GGY", "Guernsey", "");

    /* renamed from: GH */
    public static final Country f669GH = new UnicodeCountry(648, "GH", "GHA", "Ghana", "Ghanaian");

    /* renamed from: GI */
    public static final Country f670GI = new UnicodeCountry(658, "GI", "GIB", "Gibraltar", "");

    /* renamed from: GL */
    public static final Country f671GL = new UnicodeCountry(772, "GL", "GRL", "Greenland", "Greenlandic");

    /* renamed from: GM */
    public static final Country f672GM = new UnicodeCountry(624, "GM", "GMB", "Gambia", "Gambian");

    /* renamed from: GN */
    public static final Country f673GN = new UnicodeCountry(804, "GN", "GIN", "Guinea", "Guinean");

    /* renamed from: GP */
    public static final Country f674GP = new UnicodeCountry(786, "GP", "GLP", "Guadeloupe", "");

    /* renamed from: GQ */
    public static final Country f675GQ = new UnicodeCountry(550, "GQ", "GNQ", "Equatorial Guinea", "Equatorial Guinean, Equatoguinean");

    /* renamed from: GR */
    public static final Country f676GR = new UnicodeCountry(768, "GR", "GRC", "Greece", "Greek, Hellenic");

    /* renamed from: GS */
    public static final Country f677GS = new UnicodeCountry(569, "GS", "SGS", "South Georgia and the South Sandwich Islands", "");

    /* renamed from: GT */
    public static final Country f678GT = new UnicodeCountry(800, "GT", "GTM", "Guatemala", "Guatemalan");

    /* renamed from: GU */
    public static final Country f679GU = new UnicodeCountry(790, "GU", "GUM", "Guam", "Guamanian");

    /* renamed from: GW */
    public static final Country f680GW = new UnicodeCountry(1572, "GW", "GNB", "Guinea-Bissau", "Guinean");

    /* renamed from: GY */
    public static final Country f681GY = new UnicodeCountry(808, "GY", "GUY", "Guyana", "Guyanese");

    /* renamed from: HK */
    public static final Country f682HK = new UnicodeCountry(836, "HK", "HKG", "Hong Kong SAR China", "Hong Kong, Hongkongese");

    /* renamed from: HM */
    public static final Country f683HM = new UnicodeCountry(820, "HM", "HMD", "Heard Island and McDonald Islands", "");

    /* renamed from: HN */
    public static final Country f684HN = new UnicodeCountry(832, "HN", "HND", "Honduras", "Honduran");

    /* renamed from: HR */
    public static final Country f685HR = new UnicodeCountry(401, "HR", "HRV", "Croatia", "Croatian");

    /* renamed from: HT */
    public static final Country f686HT = new UnicodeCountry(818, "HT", "HTI", "Haiti", "Haitian");

    /* renamed from: HU */
    public static final Country f687HU = new UnicodeCountry(840, "HU", "HUN", "Hungary", "Hungarian");

    /* renamed from: ID */
    public static final Country f688ID = new UnicodeCountry(864, "ID", "IDN", "Indonesia", "Indonesian");

    /* renamed from: IE */
    public static final Country f689IE = new UnicodeCountry(882, "IE", "IRL", "Ireland", "Irish");

    /* renamed from: IL */
    public static final Country f690IL = new UnicodeCountry(886, "IL", "ISR", "Israel", "Israeli");

    /* renamed from: IM */
    public static final Country f691IM = new UnicodeCountry(2099, "IM", "IMN", "Isle of Man", "Manx");

    /* renamed from: IN */
    public static final Country f692IN = new UnicodeCountry(854, "IN", "IND", "India", "Indian");

    /* renamed from: IO */
    public static final Country f693IO = new UnicodeCountry(134, "IO", "IOT", "British Indian Ocean Territory", "");

    /* renamed from: IQ */
    public static final Country f694IQ = new UnicodeCountry(872, "IQ", "IRQ", "Iraq", "Iraqi");

    /* renamed from: IR */
    public static final Country f695IR = new UnicodeCountry(868, "IR", "IRN", "Iran", "Iranian, Persian");

    /* renamed from: IS */
    public static final Country f696IS = new UnicodeCountry(850, "IS", "ISL", "Iceland", "Icelandic");

    /* renamed from: IT */
    public static final Country f697IT = new UnicodeCountry(896, "IT", "ITA", "Italy", "Italian");

    /* renamed from: JE */
    public static final Country f698JE = new UnicodeCountry(2098, "JE", "JEY", "Jersey", "");

    /* renamed from: JM */
    public static final Country f699JM = new UnicodeCountry(904, "JM", "JAM", "Jamaica", "Jamaican");

    /* renamed from: JO */
    public static final Country f700JO = new UnicodeCountry(1024, "JO", "JOR", "Jordan", "Jordanian");

    /* renamed from: JP */
    public static final Country f701JP = new UnicodeCountry(914, "JP", "JPN", "Japan", "Japanese");

    /* renamed from: KE */
    public static final Country f702KE = new UnicodeCountry(1028, "KE", "KEN", "Kenya", "Kenyan");

    /* renamed from: KG */
    public static final Country f703KG = new UnicodeCountry(1047, "KG", "KGZ", "Kyrgyzstan", "Kyrgyz");

    /* renamed from: KH */
    public static final Country f704KH = new UnicodeCountry(278, "KH", "KHM", "Cambodia", "Cambodian");

    /* renamed from: KI */
    public static final Country f705KI = new UnicodeCountry(662, "KI", "KIR", "Kiribati", "I-Kiribati");

    /* renamed from: KM */
    public static final Country f706KM = new UnicodeCountry(372, "KM", "COM", "Comoros", "Comorian");

    /* renamed from: KN */
    public static final Country f707KN = new UnicodeCountry(1625, "KN", "KNA", "Saint Kitts and Nevis", "");

    /* renamed from: KP */
    public static final Country f708KP = new UnicodeCountry(1032, "KP", "PRK", "North Korea", "North Korean");

    /* renamed from: KR */
    public static final Country f709KR = new UnicodeCountry(1040, "KR", "KOR", "South Korea", "South Korean");

    /* renamed from: KW */
    public static final Country f710KW = new UnicodeCountry(1044, "KW", "KWT", "Kuwait", "Kuwaiti");

    /* renamed from: KY */
    public static final Country f711KY = new UnicodeCountry(310, "KY", "CYM", "Cayman Islands", "Caymanian");

    /* renamed from: KZ */
    public static final Country f712KZ = new UnicodeCountry(920, "KZ", "KAZ", "Kazakhstan", "Kazakh");

    /* renamed from: LA */
    public static final Country f713LA = new UnicodeCountry(1048, "LA", "Lao", "Laos", "Lao");

    /* renamed from: LB */
    public static final Country f714LB = new UnicodeCountry(1058, "LB", "LBN", "Lebanon", "Lebanese");

    /* renamed from: LC */
    public static final Country f715LC = new UnicodeCountry(1634, "LC", "LCA", "Saint Lucia", "Saint Lucian");

    /* renamed from: LI */
    public static final Country f716LI = new UnicodeCountry(1080, "LI", "LIE", "Liechtenstein", "");

    /* renamed from: LK */
    public static final Country f717LK = new UnicodeCountry(324, "LK", "LKA", "Sri Lanka", "Sri Lankan");

    /* renamed from: LR */
    public static final Country f718LR = new UnicodeCountry(1072, "LR", "LBR", "Liberia", "Liberian");

    /* renamed from: LS */
    public static final Country f719LS = new UnicodeCountry(1062, "LS", "LSO", "Lesotho", "Basotho");

    /* renamed from: LT */
    public static final Country f720LT = new UnicodeCountry(1088, "LT", "LTU", "Lithuania", "Lithuanian");

    /* renamed from: LU */
    public static final Country f721LU = new UnicodeCountry(1090, "LU", "LUX", "Luxembourg", "Luxembourg, Luxembourgish");

    /* renamed from: LV */
    public static final Country f722LV = new UnicodeCountry(1064, "LV", "LVA", "Latvia", "Latvian");

    /* renamed from: LY */
    public static final Country f723LY = new UnicodeCountry(1076, "LY", "LBY", "Libya", "Libyan");

    /* renamed from: MA */
    public static final Country f724MA = new UnicodeCountry(1284, "MA", "MAR", "Morocco", "Moroccan");

    /* renamed from: MC */
    public static final Country f725MC = new UnicodeCountry(1170, "MC", "MCO", "Monaco", "Monegasque, Monacan");

    /* renamed from: MD */
    public static final Country f726MD = new UnicodeCountry(1176, "MD", "MDA", "Moldova", "Moldovan");

    /* renamed from: ME */
    public static final Country f727ME = new UnicodeCountry(1177, "ME", "MNE", "Montenegro", "Montenegrin");

    /* renamed from: MF */
    public static final Country f728MF = new UnicodeCountry(1635, "MF", "MAF", "Saint Martin", "");

    /* renamed from: MG */
    public static final Country f729MG = new UnicodeCountry(1104, "MG", "MDG", "Madagascar", "Malagasy");

    /* renamed from: MH */
    public static final Country f730MH = new UnicodeCountry(1412, "MH", "MHL", "Marshall Islands", "Marshallese");

    /* renamed from: MK */
    public static final Country f731MK = new UnicodeCountry(2055, "MK", "MKD", "Macedonia", "Macedonian");

    /* renamed from: ML */
    public static final Country f732ML = new UnicodeCountry(1126, "ML", "MLI", "Mali", "Malian");

    /* renamed from: MM */
    public static final Country f733MM = new UnicodeCountry(260, "MM", "MMR", "Myanmar [Burma]", "Burmese");

    /* renamed from: MN */
    public static final Country f734MN = new UnicodeCountry(1174, "MN", "MNG", "Mongolia", "Mongolian");

    /* renamed from: MO */
    public static final Country f735MO = new UnicodeCountry(1094, "MO", "MAC", "Macau SAR China", "Macanese, Chinese");

    /* renamed from: MP */
    public static final Country f736MP = new UnicodeCountry(1408, "MP", "MNP", "Northern Mariana Islands", "Northern Marianan");

    /* renamed from: MQ */
    public static final Country f737MQ = new UnicodeCountry(1140, "MQ", "MTQ", "Martinique", "Martiniquais, Martinican");

    /* renamed from: MR */
    public static final Country f738MR = new UnicodeCountry(1144, "MR", "MRT", "Mauritania", "Mauritanian");

    /* renamed from: MS */
    public static final Country f739MS = new UnicodeCountry(1280, "MS", "MSR", "Montserrat", "Montserratian");

    /* renamed from: MT */
    public static final Country f740MT = new UnicodeCountry(1136, "MT", "MLT", "Malta", "Maltese");

    /* renamed from: MU */
    public static final Country f741MU = new UnicodeCountry(1152, "MU", "MUS", "Mauritius", "Mauritian");

    /* renamed from: MV */
    public static final Country f742MV = new UnicodeCountry(1122, "MV", "MDV", "Maldives", "Maldivian");

    /* renamed from: MW */
    public static final Country f743MW = new UnicodeCountry(1108, "MW", "MWI", "Malawi", "Malawian");

    /* renamed from: MX */
    public static final Country f744MX = new UnicodeCountry(1156, "MX", "MEX", "Mexico", "Mexican");

    /* renamed from: MY */
    public static final Country f745MY = new UnicodeCountry(1112, "MY", "MYS", "Malaysia", "Malaysian");

    /* renamed from: MZ */
    public static final Country f746MZ = new UnicodeCountry(1288, "MZ", "MOZ", "Mozambique", "Mozambican");

    /* renamed from: NA */
    public static final Country f747NA = new UnicodeCountry(1302, "NA", "NAM", "Namibia", "Namibian");

    /* renamed from: NC */
    public static final Country f748NC = new UnicodeCountry(1344, "NC", "NCL", "New Caledonia", "New Caledonian");

    /* renamed from: NE */
    public static final Country f749NE = new UnicodeCountry(1378, "NE", "NER", "Niger", "Nigerien");

    /* renamed from: NF */
    public static final Country f750NF = new UnicodeCountry(1396, "NF", "NFK", "Norfolk Island", "");

    /* renamed from: NG */
    public static final Country f751NG = new UnicodeCountry(1382, "NG", "NGA", "Nigeria", "Nigerian");

    /* renamed from: NI */
    public static final Country f752NI = new UnicodeCountry(1368, "NI", "NIC", "Nicaragua", "Nicaraguan");

    /* renamed from: NL */
    public static final Country f753NL = new UnicodeCountry(1320, "NL", "NLD", "Netherlands", "Dutch");

    /* renamed from: NO */
    public static final Country f754NO = new UnicodeCountry(1400, "NO", "NOR", "Norway", "Norwegian");

    /* renamed from: NP */
    public static final Country f755NP = new UnicodeCountry(1316, "NP", "NPL", "Nepal", "Nepali");

    /* renamed from: NR */
    public static final Country f756NR = new UnicodeCountry(1312, "NR", "NRU", "Nauru", "Nauruan");

    /* renamed from: NU */
    public static final Country f757NU = new UnicodeCountry(1392, "NU", "NIU", "Niue", "Niuean");

    /* renamed from: NZ */
    public static final Country f758NZ = new UnicodeCountry(1364, "NZ", "NZL", "New Zealand", "");

    /* renamed from: OM */
    public static final Country f759OM = new UnicodeCountry(1298, "OM", "OMN", "Oman", "Omani");

    /* renamed from: PA */
    public static final Country f760PA = new UnicodeCountry(1425, "PA", "PAN", "Panama", "Panamanian");

    /* renamed from: PE */
    public static final Country f761PE = new UnicodeCountry(1540, "PE", "PER", "Peru", "Peruvian");

    /* renamed from: PF */
    public static final Country f762PF = new UnicodeCountry(600, "PF", "PYF", "French Polynesia", "French Polynesian");

    /* renamed from: PG */
    public static final Country f763PG = new UnicodeCountry(1432, "PG", "PNG", "Papua New Guinea", "Papua New Guinean, Papuan");

    /* renamed from: PH */
    public static final Country f764PH = new UnicodeCountry(1544, "PH", "PHL", "Philippines", "Philippine, Filipino");

    /* renamed from: PK */
    public static final Country f765PK = new UnicodeCountry(1414, "PK", "PAK", "Pakistan", "Pakistani");

    /* renamed from: PL */
    public static final Country f766PL = new UnicodeCountry(1558, "PL", "POL", "Poland", "Polish");

    /* renamed from: PM */
    public static final Country f767PM = new UnicodeCountry(1638, "PM", "SPM", "Saint Pierre and Miquelon", "Saint Pierrais, Miquelonnais");

    /* renamed from: PN */
    public static final Country f768PN = new UnicodeCountry(1554, "PN", "PCN", "Pitcairn Islands", "");

    /* renamed from: PR */
    public static final Country f769PR = new UnicodeCountry(1584, "PR", "PRI", "Puerto Rico", "Puerto Rican");

    /* renamed from: PS */
    public static final Country f770PS = new UnicodeCountry(629, "PS", "PSE", "Palestinian Territories", "Palestinian");

    /* renamed from: PT */
    public static final Country f771PT = new UnicodeCountry(1568, "PT", "PRT", "Portugal", "Portuguese");

    /* renamed from: PW */
    public static final Country f772PW = new UnicodeCountry(1413, "PW", "PLW", "Palau", "Palauan");

    /* renamed from: PY */
    public static final Country f773PY = new UnicodeCountry(1536, "PY", "PRY", "Paraguay", "Paraguayan");

    /* renamed from: QA */
    public static final Country f774QA = new UnicodeCountry(1588, "QA", "QAT", "Qatar", "Qatari");

    /* renamed from: RE */
    public static final Country f775RE = new UnicodeCountry(1592, "RE", "REU", "Réunion", "Reunionese, Reunionnais");

    /* renamed from: RO */
    public static final Country f776RO = new UnicodeCountry(1602, "RO", "ROU", "Romania", "Romanian");

    /* renamed from: RS */
    public static final Country f777RS = new UnicodeCountry(1672, "RS", "SRB", "Serbia", "Serbian");

    /* renamed from: RU */
    public static final Country f778RU = new UnicodeCountry(1603, "RU", "RUS", "Russia", "Russian");

    /* renamed from: RW */
    public static final Country f779RW = new UnicodeCountry(1606, "RW", "RWA", "Rwanda", "Rwandan");

    /* renamed from: SA */
    public static final Country f780SA = new UnicodeCountry(1666, "SA", "SAU", "Saudi Arabia", "Saudi, Saudi Arabian");

    /* renamed from: SB */
    public static final Country f781SB = new UnicodeCountry(144, "SB", "SLB", "Solomon Islands", "Solomon Island");

    /* renamed from: SC */
    public static final Country f782SC = new UnicodeCountry(1680, "SC", "SYC", "Seychelles", "Seychellois");

    /* renamed from: SD */
    public static final Country f783SD = new UnicodeCountry(1846, "SD", "SDN", "Sudan", "Sudanese");

    /* renamed from: SE */
    public static final Country f784SE = new UnicodeCountry(1874, "SE", "SWE", "Sweden", "Swedish");

    /* renamed from: SG */
    public static final Country f785SG = new UnicodeCountry(1794, "SG", "SGP", "Singapore", "");

    /* renamed from: SH */
    public static final Country f786SH = new UnicodeCountry(1620, "SH", "SHN", "Saint Helena", "Saint Helenian");

    /* renamed from: SI */
    public static final Country f787SI = new UnicodeCountry(1797, "SI", "SVN", "Slovenia", "Slovenian, Slovene");

    /* renamed from: SJ */
    public static final Country f788SJ = new UnicodeCountry(1860, "SJ", "SJM", "Svalbard and Jan Mayen", "");

    /* renamed from: SK */
    public static final Country f789SK = new UnicodeCountry(1795, "SK", "SVK", "Slovakia", "Slovak");

    /* renamed from: SL */
    public static final Country f790SL = new UnicodeCountry(1684, "SL", "SLE", "Sierra Leone", "Sierra Leonean");

    /* renamed from: SM */
    public static final Country f791SM = new UnicodeCountry(1652, "SM", "SMR", "San Marino", "Sammarinese");

    /* renamed from: SN */
    public static final Country f792SN = new UnicodeCountry(1670, "SN", "SEN", "Senegal", "Senegalese");

    /* renamed from: SO */
    public static final Country f793SO = new UnicodeCountry(1798, "SO", "SOM", "Somalia", "Somali, Somalian");

    /* renamed from: SR */
    public static final Country f794SR = new UnicodeCountry(1856, "SR", "SUR", "Suriname", "Surinamese");

    /* renamed from: ST */
    public static final Country f795ST = new UnicodeCountry(1656, "ST", "STP", "São Tomé & Príncipe", "Sao Tomean");

    /* renamed from: SV */
    public static final Country f796SV = new UnicodeCountry(546, "SV", "SLV", "El Salvador", "Salvadoran");

    /* renamed from: SY */
    public static final Country f797SY = new UnicodeCountry(1888, "SY", "SYR", "Syria", "Syrian");

    /* renamed from: SZ */
    public static final Country f798SZ = new UnicodeCountry(1864, "SZ", "SWZ", "Swaziland", "Swazi");

    /* renamed from: TC */
    public static final Country f799TC = new UnicodeCountry(1942, "TC", "TCA", "Turks and Caicos Islands", "");

    /* renamed from: TD */
    public static final Country f800TD = new UnicodeCountry(328, "TD", "TCD", "Chad", "Chadian");

    /* renamed from: TF */
    public static final Country f801TF = new UnicodeCountry(608, "TF", "ATF", "French Southern Territories", "");

    /* renamed from: TG */
    public static final Country f802TG = new UnicodeCountry(1896, "TG", "TGO", "Togo", "Togolese");

    /* renamed from: TH */
    public static final Country f803TH = new UnicodeCountry(1892, "TH", "THA", "Thailand", "Thai");

    /* renamed from: TJ */
    public static final Country f804TJ = new UnicodeCountry(1890, "TJ", "TJK", "Tajikistan", "Tajikistani");

    /* renamed from: TK */
    public static final Country f805TK = new UnicodeCountry(1906, "TK", "TKL", "Tokelau", "");

    /* renamed from: TL */
    public static final Country f806TL = new UnicodeCountry(1574, "TL", "TLS", "Timor-Leste", "Timorese");

    /* renamed from: TM */
    public static final Country f807TM = new UnicodeCountry(1941, "TM", "TKM", "Turkmenistan", "Turkmen");

    /* renamed from: TN */
    public static final Country f808TN = new UnicodeCountry(1928, "TN", "TUN", "Tunisia", "Tunisian");

    /* renamed from: TO */
    public static final Country f809TO = new UnicodeCountry(1910, "TO", "TON", "Tonga", "Tongan");

    /* renamed from: TR */
    public static final Country f810TR = new UnicodeCountry(1938, "TR", "TUR", "Turkey", "Turkish");

    /* renamed from: TT */
    public static final Country f811TT = new UnicodeCountry(1920, "TT", "TTO", "Trinidad and Tobago", "Trinidadian, Tobagonian");

    /* renamed from: TV */
    public static final Country f812TV = new UnicodeCountry(1944, "TV", "TUV", "Tuvalu", "Tuvaluan");

    /* renamed from: TW */
    public static final Country f813TW = new UnicodeCountry(344, "TW", "TWN", "Taiwan", "Taiwanese");

    /* renamed from: TZ */
    public static final Country f814TZ = new UnicodeCountry(2100, "TZ", "TZA", "Tanzania", "Tanzanian");

    /* renamed from: UA */
    public static final Country f815UA = new UnicodeCountry(2052, "UA", "UKR", "Ukraine", "Ukrainian");

    /* renamed from: UG */
    public static final Country f816UG = new UnicodeCountry(2048, "UG", "UGA", "Uganda", "Ugandan");

    /* renamed from: UM */
    public static final Country f817UM = new UnicodeCountry(1409, "UM", "UMI", "U.S. Outlying Islands", "");

    /* renamed from: US */
    public static final Country f818US = new UnicodeCountry(2112, "US", "USA", "United States", "American");

    /* renamed from: UY */
    public static final Country f819UY = new UnicodeCountry(2136, "UY", "URY", "Uruguay", "Uruguayan");

    /* renamed from: UZ */
    public static final Country f820UZ = new UnicodeCountry(2144, "UZ", "UZB", "Uzbekistan", "Uzbekistani, Uzbek");

    /* renamed from: VA */
    public static final Country f821VA = new UnicodeCountry(822, "VA", "VAT", "Vatican City", "");

    /* renamed from: VC */
    public static final Country f822VC = new UnicodeCountry(1648, "VC", "VCT", "Saint Vincent and the Grenadines", "Saint Vincentian");

    /* renamed from: VE */
    public static final Country f823VE = new UnicodeCountry(2146, "VE", "VEN", "Venezuela", "Venezuelan");

    /* renamed from: VG */
    public static final Country f824VG = new UnicodeCountry(146, "VG", "VGB", "British Virgin Islands", "Virgin Island");

    /* renamed from: VI */
    public static final Country f825VI = new UnicodeCountry(2128, "VI", "VIR", "U.S. Virgin Islands", "Virgin Island");

    /* renamed from: VN */
    public static final Country f826VN = new UnicodeCountry(1796, "VN", "VNM", "Vietnam", "Vietnamese");

    /* renamed from: VU */
    public static final Country f827VU = new UnicodeCountry(1352, "VU", "VUT", "Vanuatu", "Ni-Vanuatu, Vanuatuan");

    /* renamed from: WF */
    public static final Country f828WF = new UnicodeCountry(2166, "WF", "WLF", "Wallis and Futuna", "Wallisian, Futunan");

    /* renamed from: WS */
    public static final Country f829WS = new UnicodeCountry(2178, "WS", "WSM", "Samoa", "Samoan");

    /* renamed from: YE */
    public static final Country f830YE = new UnicodeCountry(2183, "YE", "YEM", "Yemen", "Yemeni");

    /* renamed from: YT */
    public static final Country f831YT = new UnicodeCountry(373, "YT", "MYT", "Mayotte", "Mahoran");

    /* renamed from: ZA */
    public static final Country f832ZA = new UnicodeCountry(1808, "ZA", "ZAF", "South Africa", "South African");

    /* renamed from: ZM */
    public static final Country f833ZM = new UnicodeCountry(2196, "ZM", "ZMB", "Zambia", "Zambian");

    static {
        UnicodeCountry unicodeCountry = new UnicodeCountry(1814, "ZW", "ZWE", "Zimbabwe", "Zimbabwean");
        f834ZW = unicodeCountry;
        VALUES = new Country[]{f589AD, f590AE, f591AF, f592AG, f593AI, f594AL, f595AM, f596AN, f597AO, f598AQ, f599AR, f600AS, f601AT, f602AU, f603AW, f604AX, f605AZ, f606BA, f607BB, f608BD, f609BE, f610BF, f611BG, f612BH, f613BI, f614BJ, f615BL, f616BM, f617BN, f618BO, f619BR, f620BS, f621BT, f622BV, f623BW, f624BY, f625BZ, f626CA, f627CC, f628CD, f629CF, f630CG, f631CH, f632CI, f633CK, f634CL, f635CM, f636CN, f637CO, f638CR, f639CU, f640CV, f641CX, f642CY, f643CZ, f644DE, f645DJ, f646DK, f647DM, f648DO, f649DZ, f650EC, f651EE, f652EG, f653EH, f654ER, f655ES, f656ET, f657FI, f658FJ, f659FK, f660FM, f661FO, f662FR, f663GA, f664GB, f665GD, f666GE, f667GF, f668GG, f669GH, f670GI, f671GL, f672GM, f673GN, f674GP, f675GQ, f676GR, f677GS, f678GT, f679GU, f680GW, f681GY, f682HK, f683HM, f684HN, f685HR, f686HT, f687HU, f688ID, f689IE, f690IL, f691IM, f692IN, f693IO, f694IQ, f695IR, f696IS, f697IT, f698JE, f699JM, f700JO, f701JP, f702KE, f703KG, f704KH, f705KI, f706KM, f707KN, f708KP, f709KR, f710KW, f711KY, f712KZ, f713LA, f714LB, f715LC, f716LI, f717LK, f718LR, f719LS, f720LT, f721LU, f722LV, f723LY, f724MA, f725MC, f726MD, f727ME, f728MF, f729MG, f730MH, f731MK, f732ML, f733MM, f734MN, f735MO, f736MP, f737MQ, f738MR, f739MS, f740MT, f741MU, f742MV, f743MW, f744MX, f745MY, f746MZ, f747NA, f748NC, f749NE, f750NF, f751NG, f752NI, f753NL, f754NO, f755NP, f756NR, f757NU, f758NZ, f759OM, f760PA, f761PE, f762PF, f763PG, f764PH, f765PK, f766PL, f767PM, f768PN, f769PR, f770PS, f771PT, f772PW, f773PY, f774QA, f775RE, f776RO, f777RS, f778RU, f779RW, f780SA, f781SB, f782SC, f783SD, f784SE, f785SG, f786SH, f787SI, f788SJ, f789SK, f790SL, f791SM, f792SN, f793SO, f794SR, f795ST, f796SV, f797SY, f798SZ, f799TC, f800TD, f801TF, f802TG, f803TH, f804TJ, f805TK, f806TL, f807TM, f808TN, f809TO, f810TR, f811TT, f812TV, f813TW, f814TZ, f815UA, f816UG, f817UM, f818US, f819UY, f820UZ, f821VA, f822VC, f823VE, f824VG, f825VI, f826VN, f827VU, f828WF, f829WS, f830YE, f831YT, f832ZA, f833ZM, unicodeCountry};
    }

    private UnicodeCountry(int code, String alpha2Code, String alpha3Code, String name, String nationality) {
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
        UnicodeCountry other = (UnicodeCountry) obj;
        return other.code == this.code;
    }

    public int compareTo(Country o) {
        return toAlpha2Code().compareTo(o.toAlpha2Code());
    }
}
