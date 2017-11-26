# Project Title

  Ascent Software - 7SnakeProblem

## Getting Started

  

### Prerequisites

  Java 8

### Installing

  1 - Download the 7SnakeProblem project and save into a folder of your choice;<br>
  2 - Unzip the file;<br>
  3 - Copy the folder 7SnakeProblem to your java workspace;<br>
  4 - Open your Eclipse IDE;<br>
  5 - Switch to the workpace where you copy the project;<br>
    5.1 - Click File, then Switch Workspace, then Other in the IDE top menu;<br>
    5.2 - Brows to the workspace that you saved the project then click the OK button;<br>
    5.3 - The Eclipse IDE will be reloaded automatically;<br>
  6 - Import this JAVA project as Existing Projects into Workspace;<br>
    6.1 - Click in File then Import in the IDE top menu;<br>
    6.2 - On the Selectec an import wizard field, type "Existing Projects into Workspace";<br>
    6.3 = Select this option then click the Next button;<br>
    6.4 - On the "Select root directory" field, click the "Browse..." button;<br>
    6.5 - Select 7SnakeProblem folder inside your workspace, then click Open button, then Finish button;<br>

## Running the tests

   1 - Run the project;<br>
    1.1 - Navigate to the MainStage.java class locate in src/com/ascent_software;<br>
    1.2 - Click the right mouse button over the class name, then click "Run As / Java Application";<br>
    1.3 - The application will show in the "Console" tab:<br>
      1.3.1 - The matrix imported from the file "grid_B.csv" located at the root of the project;<br>
      1.3.2 - Result of the comparison between a random snake (snake A) and its respective snake B in the matrix, in case there is no equivalent snake, FAIL will be printed on the respective line;<br>
    1.4 - When executing the class, the comparative is dynamically generated until an equivalence between Snake A and the amount of snakes passed as a parameter in the compareSnakes method of the Services.java class;<br>
    1.5 - As default you were asked to find only one more snake;<br>
    
    ```
    Matrix [10X10]:
          C0:	C1:	C2:	C3:	C4:	C5:	C6:	C7:	C8:	C9:
    row0:	227	191	234	67	43	13	48	211	253	243
    row1:	36	95	229	209	49	230	46	16	190	49
    row2:	206	130	85	67	104	93	128	243	38	173
    row3:	234	82	191	153	170	99	124	60	12	31
    row4:	192	9	24	127	183	241	139	21	244	66
    row5:	93	200	66	16	189	42	209	113	215	4
    row6:	182	141	153	64	229	55	115	139	12	187
    row7:	133	241	35	255	126	39	110	147	24	241
    row8:	2	202	191	159	223	128	154	109	6	200
    row9:	173	44	163	196	159	232	135	159	177	175
    --------------------------------------------------------------------------

    Snake A: {R:5 && C:0=[93] + R:6 && C:6=[182] = (275)}	===> FAIL.....
    Snake A: {R:8 && C:7=[109] + R:8 && C:8=[6] = (115)}	===> FAIL.....
    Snake A: {R:4 && C:5=[241] + R:5 && C:5=[42] = (283)}	===> FAIL.....
    Snake A: {R:4 && C:8=[244] + R:5 && C:5=[215] = (459)}	===> FAIL.....
    Snake A: {R:1 && C:3=[209] + R:1 && C:1=[49] = (258)}	===> FAIL.....
    Snake A: {R:7 && C:9=[241] + R:8 && C:8=[200] = (441)}	===> FAIL.....
    Snake A: {R:0 && C:1=[191] + R:0 && C:0=[234] = (425)}	===> FAIL.....
    Snake A: {R:1 && C:3=[209] + R:2 && C:2=[67] = (276)}	===> SnakeB {R:1 && C:5=[230] + R:1 && C:1=[46] = (276)}
    ```
## Deployment

  This is a very simple project, which is composed of a file formatted with lines of values separated by semicolons, which will be loaded and will be searched if there are two or more snakes with the same relation of values, but that do not have fields in common;<br>
  File example:<br>
  
  ```
  227;191;234;67;43;13;48;211;253;243
  36;95;229;209;49;230;46;16;190;49
  206;130;85;67;104;93;128;243;38;173
  234;82;191;153;170;99;124;60;12;31
  192;9;24;127;183;241;139;21;244;66
  93;200;66;16;189;42;209;113;215;4
  182;141;153;64;229;55;115;139;12;187
  133;241;35;255;126;39;110;147;24;241
  2;202;191;159;223;128;154;109;6;200
  173;44;163;196;159;232;135;159;177;175
  ```

## Built With

* [Eclipse Java EE IDE for Web Developers.<br>
  Version: Neon.3 Release (4.6.3)
  Build id: 20170314-1500](https://www.eclipse.org/) - IDE Java used<br>
* [JAVA 8](http://www.oracle.com/technetwork/indexes/downloads/index.html) - Dependency Management<br>

## Contributing

  Individual project developed by the author and without contribution.<br>

## Versioning

  Version 1.0<br>

## Authors

* **Renato Jiquirica Ramos** - *Initial work* - [rjamos70](https://github.com/rjramos70)<br>

## License

  Project open to anyone's use.


