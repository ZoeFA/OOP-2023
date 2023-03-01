package ie.tudublin;

public class PitchSpeller {

  //array of frequen
  float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, /*d4*/ 
                        587.33f, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, /*d5*/
                        1174.66f, 1318.5f, 1480.0f, 1568.0f, 1760.0f, 1975.5f, 2217.5f,/*d6 */
                        2349.3f, 2637.0f, 2960.0f, 3136.9f, 3520.0f, 3951.1f, 4434.9f,/*d7 */
                        4698.6f /*d8 */};
//c and f sharp
  String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", /*d4*/
                        "D", "E", "F", "G", "A", "B","c", /*d5 */
                        "d", "e", "f", "g", "a", "b", "c'", /*d6 */
                        "d'", "e'", "f'", "g'", "a'", "b'", "c''", /*d7 */
                        "d''"/*d8 */
                        };
                        //, "e''", "f''", "g''", "a''", "b''", "c''"
  

  String spell(float frequency){

    for (int i = 0; i < frequencies.length; i++){
      if(frequency < frequencies[i + 1]){

        return spellings[i];
      }
    }

    return "" ;
  }

}

 

  

}