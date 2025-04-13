package org.buildcode;

public class Main {
    public static void main(String[] args) {
        // https://leetcode.com/discuss/interview-question/4589653/PhonePe-Machine-Coding-Round-or-2-YOE

        Account account = new Account(
                "accountId1",
                "email@gmail.com",
                "password"
        );

        User user = new User(
                "userId1",
                account,
                "firstName",
                "lastName",
                "phoneNumber",
                new Address()
        );

        VersionManager versionManager = new StackBasedVersionManager();
        DocumentFactory documentFactory = new TextDocumentFactory(versionManager);

        Document document = documentFactory.createDocument("docId", user);

        DocumentProxy documentProxy = new DocumentProxy(document, user);

        Content content = documentProxy.view();
        content.edit("New Content");
        documentProxy.edit(content);

        System.out.println("After Editing: " + documentProxy.view());

        documentProxy.update();

        System.out.println("Saved the version!");

        Content changedContent = documentProxy.view();
        changedContent.edit("Changed the Content");
        documentProxy.edit(changedContent);

        System.out.println("Changed the content");
        System.out.println("Current view: " + documentProxy.view());

        documentProxy.revert();

        System.out.println("After reverting: " + documentProxy.view());

        Account anotherAccount = new Account(
                "accountId2",
                "diffemail@gmail.com",
                "password"
        );

        User anotherUser = new User(
                "userId2",
                anotherAccount, // Fixed to use anotherAccount
                "firstName",
                "lastName",
                "phoneNumber",
                new Address()
        );

        System.out.println("Trying to edit by diff user...");

        try {
            DocumentProxy anotherUserProxy = new DocumentProxy(document, anotherUser);

            Content anotherContent = anotherUserProxy.view();
            anotherContent.edit("Attempt by another user");

            anotherUserProxy.edit(anotherContent);

            System.out.println("Edit by another user: " + anotherUserProxy.view());
        } catch (Exception e) {
            System.out.println("Edit failed: Unauthorized access by another user.");
        }

        System.out.println("Test complete.");
    }
}