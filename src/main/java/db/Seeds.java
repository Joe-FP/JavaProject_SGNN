package db;

import models.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Seeds {

    public static void seedData(){
        DBHelper.deleteAll(Rating.class);
        DBHelper.deleteAll(Article.class);
        DBHelper.deleteAll(Journalist.class);



        Journalist journalist1 = new Journalist("Vivian Rook", JournalismType.Broadcast);
        DBHelper.save(journalist1);
        Journalist journalist2 = new Journalist("Tony Hills", JournalismType.Sport);
        DBHelper.save(journalist2);
        Journalist journalist3 = new Journalist("Ford Prefect", JournalismType.Communication);
        DBHelper.save(journalist3);
        Journalist journalist4 = new Journalist("Bridget Jones", JournalismType.Foreign);
        DBHelper.save(journalist4);
        Journalist journalist5 = new Journalist("Matt Anders", JournalismType.PR);
        DBHelper.save(journalist5);

//         Article article1 = new Article(journalist1, "Title_1", "2018-08-22", CategoryType.Weather, "/images/article-images/achievement-agreement-arms-1068523.jpg", "summary", "full article");
//         DBHelper.save(article1);

        Article article1 = new Article(journalist1, "Lorem Ipsum1", formattedDate, CategoryType.Weather, "/images/article-images/achievement-agreement-arms-1068523.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article1);
        Article article2 = new Article(journalist1, "Lorem Ipsum2", formattedDate, CategoryType.Business, "/images/article-images/aerial-architecture-art-1064129.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article2);
        Article article3 = new Article(journalist1, "Lorem Ipsum3", formattedDate, CategoryType.Industry, "/images/article-images/beautiful-blooming-bouquet-1083822.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article3);
        Article article4 = new Article(journalist2, "Lorem Ipsum4", formattedDate, CategoryType.Crime, "/images/article-images/botanical-bright-close-up-1073078.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article4);
        Article article5 = new Article(journalist3, "Lorem Ipsum5", formattedDate, CategoryType.Tech, "/images/article-images/camera-canon-dslr-243757.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article5);
        Article article6 = new Article(journalist5, "Lorem Ipsum6", formattedDate,CategoryType.Entertainment, "/images/article-images/achievement-agreement-arms-1068523.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article6);
        Article article7 = new Article(journalist1, "Lorem Ipsum7",formattedDate, CategoryType.Tech, "/images/article-images/aerial-architecture-art-1064129.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article7);
        Article article8 = new Article(journalist2, "Lorem Ipsum8", formattedDate,CategoryType.Politics, "/images/article-images/beautiful-blooming-bouquet-1083822.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article8);
        Article article9 = new Article(journalist3, "Lorem Ipsum9", formattedDate,CategoryType.Industry, "/images/article-images/botanical-bright-close-up-1073078.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article9);
        Article article10 = new Article(journalist4, "Lorem Ipsum10",formattedDate, CategoryType.World, "/images/article-images/camera-canon-dslr-243757.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article10);
        Article article11 = new Article(journalist5, "Lorem Ipsum11", formattedDate,CategoryType.Politics, "/images/article-images/achievement-agreement-arms-1068523.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article11);
        Article article12 = new Article(journalist3, "Lorem Ipsum12", formattedDate, CategoryType.Crime, "/images/article-images/aerial-architecture-art-1064129.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article12);
        Article article13 = new Article(journalist2, "Lorem Ipsum13",formattedDate, CategoryType.Business, "/images/article-images/beautiful-blooming-bouquet-1083822.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article13);
        Article article14 = new Article(journalist4, "Lorem Ipsum14",formattedDate, CategoryType.World, "/images/article-images/botanical-bright-close-up-1073078.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article14);
        Article article15 = new Article(journalist1, "Lorem Ipsum15",formattedDate, CategoryType.Industry, "/images/article-images/camera-canon-dslr-243757.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article15);
        Article article16 = new Article(journalist5, "Lorem Ipsum16",formattedDate, CategoryType.Entertainment, "/images/article-images/achievement-agreement-arms-1068523.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article16);
        Article article17 = new Article(journalist3, "Lorem Ipsum17",formattedDate, CategoryType.Education, "/images/article-images/aerial-architecture-art-1064129.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article17);
        Article article18 = new Article(journalist4, "Lorem Ipsum18",formattedDate, CategoryType.Health, "/images/article-images/beautiful-blooming-bouquet-1083822.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article18);
        Article article19 = new Article(journalist2, "Lorem Ipsum19",formattedDate, CategoryType.Business, "/images/article-images/botanical-bright-close-up-1073078.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article19);
        Article article20 = new Article(journalist5, "Lorem Ipsum20",formattedDate, CategoryType.Crime, "/images/article-images/camera-canon-dslr-243757.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article20);

        Rating article1Review1 = new Rating(article1, 5);
        Rating article1Review2 = new Rating(article1, 6);
        Rating article1Review3 = new Rating(article1, 7);

        DBHelper.save(article1Review1);
        DBHelper.save(article1Review2);
        DBHelper.save(article1Review3);

    }
}
