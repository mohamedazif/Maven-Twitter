package org.twitter.view;

import org.twitter.controller.ProfileEditController;
import org.twitter.model.User;

import java.util.Scanner;

public class ProfileEditView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private final ProfileEditController controller = new ProfileEditController();

    public void showEditMenu(User user) {
        System.out.println("""
                Edit Profile:
                1. Change Username
                2. Change Password
                3. Change Age
                4. Change Bio
                0. Exit""");

        int choice = SCANNER.nextInt();
        SCANNER.nextLine(); // consume newline

        try {
            switch (choice) {
                case 1 -> changeUsername(user);
                case 2 -> changePassword(user);
                case 3 -> changeAge(user);
                case 4 -> changeBio(user);
                case 0 -> System.out.println("Exiting edit menu...");
                default -> System.out.println("Invalid option!");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private void changeUsername(User user) {
        System.out.print("Enter new username: ");
        String username = SCANNER.nextLine();
        controller.changeUsername(user, username);
        System.out.println("Username changed successfully!");
    }

    private void changePassword(User user) {
        System.out.print("Enter new password: ");
        String password = SCANNER.nextLine();
        controller.changePassword(user, password);
        System.out.println("Password changed successfully!");
    }

    private void changeAge(User user) {
        System.out.print("Enter new age: ");
        int age = SCANNER.nextInt();
        controller.changeAge(user, age);
        System.out.println("Age changed successfully!");
    }

    private void changeBio(User user) {
        System.out.print("Enter new bio: ");
        String bio = SCANNER.nextLine();
        if (bio.isBlank()) {
            System.err.println("Bio cannot be blank");
            return;
        }
        controller.changeBio(user, bio);
        System.out.println("Bio updated successfully!");
    }
}
