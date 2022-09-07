package removier.mvc.view;

public interface ViewConst {
    String banner = "\n" +
            "    ____           __  ___                   _               \n" +
            "   / __ \\  ___    /  |/  /  ____   _   __   (_)  ___    _____\n" +
            "  / /_/ / / _ \\  / /|_/ /  / __ \\ | | / /  / /  / _ \\  / ___/\n" +
            " / _, _/ /  __/ / /  / /  / /_/ / | |/ /  / /  / \\__/ / /    \n" +
            "/_/ |_|  \\___/ /_/  /_/   \\____/  |___/  /_/   \\___/ /_/     \n" +
            "                                                            \n";
    String adminBanner = "\n"+
            "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          \n" +
            "                                        ____                     ,--.         ,-.----.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    \n" +
            "   ,---,            ,---,             ,'  , `.    ,---,        ,--.'|         \\    /  \\      ,---,          ,----..        ,---,.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            "  '  .' \\         .'  .' `\\        ,-+-,.' _ | ,`--.' |    ,--,:  : |         |   :    \\    '  .' \\        /   /   \\     ,'  .' |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            " /  ;    '.     ,---.'     \\    ,-+-. ;   , || |   :  : ,`--.'`|  ' :         |   |  .\\ :  /  ;    '.     |   :     :  ,---.'   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            ":  :       \\    |   |  .`\\  |  ,--.'|'   |  ;| :   |  ' |   :  :  | |         .   :  |: | :  :       \\    .   |  ;. /  |   |   .'                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            ":  |   /\\   \\   :   : |  '  | |   |  ,', |  ': |   :  | :   |   \\ | :         |   |   \\ : :  |   /\\   \\   .   ; /--`   :   :  |-,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            "|  :  ' ;.   :  |   ' '  ;  : |   | /  | |  || '   '  ; |   : '  '; |         |   : .   / |  :  ' ;.   :  ;   | ;  __  :   |  ;/|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            "|  |  ;/  \\   \\ '   | ;  .  | '   | :  | :  |, |   |  | '   ' ;.    ;         ;   | |`-'  |  |  ;/  \\   \\ |   : |.' .' |   :   .'                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            "'  :  | \\  \\ ,' |   | :  |  ' ;   . |  ; |--'  '   :  ; |   | | \\   |         |   | ;     '  :  | \\  \\ ,' .   | '_.' : |   |  |-,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            "|  |  '  '--'   '   : | /  ;  |   : |  | ,     |   |  ' '   : |  ; .'         :   ' |     |  |  '  '--'   '   ; : \\  | '   :  ;/|                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            "|  :  :         |   | '` ,/   |   : '  |/      '   :  | |   | '`--'           :   : :     |  :  :         '   | '/  .' |   |    \\                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            "|  | ,'         ;   :  .'     ;   | |`-'       ;   |.'  '   : |               |   | :     |  | ,'         |   :    /   |   :   .'                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         \n" +
            "`--''           |   ,.'       |   ;/           '---'    ;   |.'               `---'.|     `--''            \\   \\ .'    |   | ,'                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           \n" +
            "                '---'         '---'                     '---'                   `---`                       `---`      `----'         ";

    String printUserMenu = "\n" +
            "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\n" +
            "┃　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　 ┃\n" +
			"┃     1.최신영화 (Top5)     2.영화검색     3.공지사항     4. MyPage     5.Logout	  ┃\n" +
			"┃　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　 ┃\n" +
			"┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n";



    
}
