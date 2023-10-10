package pl.pierogmichal.view;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IconResolver {
    public Node getIconForFolder(String folderName) {
        String lowerCaseFolderName = folderName.toLowerCase();
        ImageView imageView;
        try {
            if (lowerCaseFolderName.contains("@")) {
                imageView = new ImageView(new Image(getClass().getResourceAsStream("/icons/email.png")));

            } else if (lowerCaseFolderName.contains("inbox")){
                imageView = new ImageView(new Image(getClass().getResourceAsStream("/icons/inbox.png")));
            } else if (lowerCaseFolderName.contains("wysłane")) {
                imageView = new ImageView(new Image(getClass().getResourceAsStream("/icons/send.png")));
            } else if (lowerCaseFolderName.contains("spam")) {
                imageView = new ImageView(new Image(getClass().getResourceAsStream("/icons/spam.png")));
            } else if (lowerCaseFolderName.contains("oznaczone gwiazdką")) {
                imageView = new ImageView(new Image(getClass().getResourceAsStream("/icons/star.png")));
            } else if (lowerCaseFolderName.contains("kosz")) {
                imageView = new ImageView(new Image(getClass().getResourceAsStream("/icons/delete.png")));
            } else if (lowerCaseFolderName.contains("ważne")) {
                imageView = new ImageView(new Image(getClass().getResourceAsStream("/icons/important.png")));
            } else {
                imageView = new ImageView(new Image(getClass().getResourceAsStream("/icons/folder.png")));
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        return imageView;
    }
}
