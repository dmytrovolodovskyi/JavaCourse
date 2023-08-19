package code_quality.game;

public class GameField {

    private boolean boxEmpty = false;

    public void getField(char[] box) {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
        updateField(box);
    }

    private void updateField(char[] box) {
        if (!boxEmpty) {
            for (int i = 0; i < 9; i++)
                box[i] = ' ';
            boxEmpty = true;
        }
    }
}
