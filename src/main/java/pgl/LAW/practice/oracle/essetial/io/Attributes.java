package pgl.LAW.practice.oracle.essetial.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Set;

public class Attributes {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("V4DB\\src\\test\\resources");
        basicFileAttributes(file);
    }

    public static void basicFileAttributes(Path file) throws IOException {
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

        System.out.println("isDirectory: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("isRegularFile: " + attr.isRegularFile());
        System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
        System.out.println("size: " + attr.size());

        // set time stamps
        long currentTime = System.currentTimeMillis();
        FileTime ft = FileTime.fromMillis(currentTime);
        Files.setLastModifiedTime(file, ft);

        // set file owner
        UserPrincipal owner = file.getFileSystem().getUserPrincipalLookupService()
                .lookupPrincipalByName("sally");
        Files.setOwner(file, owner);
        // set group owner
        GroupPrincipal group =
                file.getFileSystem().getUserPrincipalLookupService()
                        .lookupPrincipalByGroupName("green");
        Files.getFileAttributeView(file, PosixFileAttributeView.class)
                .setGroup(group);

        // user-defined attribute
        UserDefinedFileAttributeView view = Files
                .getFileAttributeView(file, UserDefinedFileAttributeView.class);
        view.write("user.mimetype",
                Charset.defaultCharset().encode("text/html"));
        // read MIME type attribute
        UserDefinedFileAttributeView view1 = Files
                .getFileAttributeView(file,UserDefinedFileAttributeView.class);
        String name = "user.mimetype";
        ByteBuffer buf = ByteBuffer.allocate(view1.size(name));
        view1.read(name, buf);
        buf.flip();
        String value = Charset.defaultCharset().decode(buf).toString();

        // print space
        FileStore store = Files.getFileStore(file);

        long total = store.getTotalSpace() / 1024;
        long used = (store.getTotalSpace() -
                store.getUnallocatedSpace()) / 1024;
        long avail = store.getUsableSpace() / 1024;
    }

    public static void dosFileAttributes(Path file) {
        try {
            DosFileAttributes attr =
                    Files.readAttributes(file, DosFileAttributes.class);
            System.out.println("isReadOnly is " + attr.isReadOnly());
            System.out.println("isHidden is " + attr.isHidden());
            System.out.println("isArchive is " + attr.isArchive());
            System.out.println("isSystem is " + attr.isSystem());

            // set a DOS attribute
            Files.setAttribute(file, "dos:hidden", true);
        } catch (UnsupportedOperationException | IOException x) {
            System.err.println("DOS file" +
                    " attributes not supported:" + x);
        }
    }

    public static void posixFileAttributes(Path file) throws IOException {
        PosixFileAttributes attr0 =
                Files.readAttributes(file, PosixFileAttributes.class);
        System.out.format("%s %s %s%n",
                attr0.owner().getName(),
                attr0.group().getName(),
                PosixFilePermissions.toString(attr0.permissions()));

        // assign attributes
        Path sourceFile = Paths.get("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\practice\\src\\main\\resources\\xanadu.txt");
        Path newFile = Paths.get("D:\\Zheng\\Documents\\2_NBS\\Java\\LAW\\practice\\src\\main\\resources\\outagain.txt");
        PosixFileAttributes attrs =
                Files.readAttributes(sourceFile, PosixFileAttributes.class);
        FileAttribute<Set<PosixFilePermission>> attr =
                PosixFilePermissions.asFileAttribute(attrs.permissions());
        Files.createFile(file, attr);

        // set permission
        Set<PosixFilePermission> perms =
                PosixFilePermissions.fromString("rw-------");
        FileAttribute<Set<PosixFilePermission>> attr1 =
                PosixFilePermissions.asFileAttribute(perms);
        Files.setPosixFilePermissions(file, perms);
    }
}
