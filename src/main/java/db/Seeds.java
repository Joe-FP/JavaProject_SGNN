package db;

import models.*;

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

        Article article1 = new Article(journalist1, "Long article Title", "2018-08-01", CategoryType.Weather,
                "/images/article-images/achievement-agreement-arms-1068523.jpg", "summary", "Lorem ipsum dolor sit " +
                "amet, consectetur adipiscing elit. Pellentesque tellus nisi, blandit ut velit eget, pretium " +
                "tincidunt massa. Donec accumsan congue odio ut efficitur. Etiam velit quam, aliquet ac venenatis ac," +
                " malesuada sed nibh. Nullam tristique mi tristique sapien vestibulum, non consequat diam vehicula. " +
                "Morbi pretium fringilla laoreet. Suspendisse potenti. Quisque at aliquam ante. Fusce a arcu mauris. " +
                "Vivamus feugiat eu metus quis sodales. Aliquam vel dui nec tortor viverra ultrices. Donec vel ex " +
                "vitae velit sodales pellentesque. Duis ligula elit, fringilla a nunc sit amet, aliquam venenatis leo" +
                ". Nullam massa elit, feugiat ac tristique vitae, fermentum ac urna. In ultricies lorem eget ligula " +
                "volutpat, vel tincidunt quam tempor. Donec maximus lacus ut ante vestibulum, ac molestie massa " +
                "aliquam.</br>" +
                "</br>" +
                "Sed cursus ante ac odio dignissim aliquam. Proin sed tempor lorem. Sed efficitur sollicitudin ligula" +
                " in rhoncus. Maecenas at arcu eget sapien tincidunt egestas vitae et mi. Nunc id consequat sem. " +
                "Suspendisse ac magna quis sapien convallis congue eget at lorem. Donec mollis felis at maximus " +
                "ornare. Ut ut orci dolor. Pellentesque vitae orci id risus tincidunt tempus quis eget erat. " +
                "Phasellus cursus consequat pretium.</br>" +
                "</br" +
                "Duis cursus bibendum turpis ac consectetur. Nullam tincidunt lobortis urna, vel tincidunt ligula " +
                "consequat ut. Mauris tellus risus, fermentum at scelerisque ac, dapibus sed arcu. Fusce quis aliquet" +
                " enim, nec pretium dolor. Donec sollicitudin ullamcorper tellus sit amet varius. Sed rutrum mi est. " +
                "Curabitur enim massa, tempus tincidunt vulputate vitae, elementum ut mauris. Aliquam eget augue " +
                "efficitur, blandit erat tempor, condimentum sem.</br>" +
                "</br>" +
                "Maecenas enim tellus, lacinia vel mollis in, sollicitudin ut mauris. Curabitur at porttitor mauris. " +
                "Nam augue quam, pharetra eget massa non, varius venenatis justo. Nam sit amet iaculis dolor. " +
                "Praesent nunc metus, posuere ut cursus dapibus, vulputate id eros. Donec risus ipsum, tempor in " +
                "dignissim lobortis, bibendum et nisl. Fusce posuere quam sed ante efficitur, non suscipit dui " +
                "ultrices. Pellentesque hendrerit rutrum nibh vel accumsan. Quisque at elit aliquam, condimentum arcu" +
                " vitae, blandit quam. Sed volutpat justo quis enim sollicitudin hendrerit. In aliquam quam ex, vel " +
                "vestibulum arcu placerat id.</br>" +
                "</br>" +
                "Maecenas ut magna gravida, euismod mauris ut, feugiat mauris. Mauris interdum commodo nunc ac " +
                "maximus. Sed erat ante, tincidunt a ipsum ut, fringilla euismod libero. Curabitur lobortis facilisis imperdiet. Sed venenatis nisl vitae tristique posuere. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec lobortis ornare orci et fringilla. Pellentesque id faucibus ligula. Nullam et nunc scelerisque, volutpat nibh in, dictum est. Quisque molestie, urna eu condimentum ultricies, est mauris sagittis magna, ut varius nulla metus id turpis. Lorem ipsum dolor sit amet, consectetur adipiscing elit.");


        DBHelper.save(article1);
        Article article2 = new Article(journalist2, "Headline 2", "2018-08-02", CategoryType.Business, "/images/article-images/aerial-architecture-art-1064129.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article2);
        Article article3 = new Article(journalist3, "Headline 3", "2018-08-03", CategoryType.Industry, "/images/article-images/botanical-bright-close-up-1073078.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article3);
        Article article4 = new Article(journalist4, "Headline 4", "2018-08-04", CategoryType.Crime, "/images/article-images/camera-canon-dslr-243757.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article4);
        Article article5 = new Article(journalist5, "Headline 5", "2018-08-05", CategoryType.Tech, "/images/article-images/car-climb-clouds-679072.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article5);
        Article article6 = new Article(journalist1, "Headline 6", "2018-07-22",CategoryType.Weather, "/images/article-images/beautiful-blooming-bouquet-1083822.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article6);
        Article article7 = new Article(journalist2, "Headline 7","2018-08-23", CategoryType.Business, "/images/article-images/achievement-agreement-arms-1068523.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article7);
        Article article8 = new Article(journalist3, "Headline 8", "2018-08-24",CategoryType.Industry, "/images/article-images/aerial-architecture-art-1064129.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article8);
        Article article9 = new Article(journalist4, "Headline 9", "2018-08-23",CategoryType.Crime, "/images/article-images/botanical-bright-close-up-1073078.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article9);
        Article article10 = new Article(journalist5, "Headline 10","2018-08-23", CategoryType.Tech, "/images/article-images/car-climb-clouds-679072.jpg", "summary", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut euismod velit mauris, in rutrum velit interdum et. Vestibulum convallis nibh non consectetur dictum. Curabitur mattis dolor sit amet turpis fringilla vulputate. Nulla facilisi. Maecenas condimentum justo ac ligula lacinia blandit. Proin imperdiet ultrices velit vel pretium. Integer finibus gravida orci in dictum. Donec eget sodales risus. Nulla scelerisque quam ex, eget semper lectus faucibus varius. Nam pulvinar nisi dolor, eget euismod ex sodales in. Fusce sollicitudin rutrum blandit. Nam ullamcorper hendrerit massa eget efficitur. Donec maximus ut orci fermentum dictum. Maecenas semper dolor vitae elit sollicitudin, efficitur vehicula leo ultricies. Duis lectus nibh, aliquam ut ipsum at, rutrum condimentum metus. Phasellus finibus libero quam, mollis pharetra mi feugiat accumsan. Fusce fringilla dolor eget porta tincidunt. Curabitur auctor sodales dolor nec placerat. In hac habitasse platea dictumst. Proin auctor ligula interdum, finibus felis eget, ultrices nulla. Morbi condimentum volutpat lorem, in lobortis ipsum volutpat sit amet. Aenean consequat congue orci in imperdiet. Pellentesque malesuada urna et nulla vestibulum aliquet sed et orci. Donec posuere mattis arcu quis pellentesque. Nunc suscipit semper fermentum. Vivamus commodo fringilla nibh, sit amet placerat enim tincidunt");
        DBHelper.save(article10);


        Rating article1Review1 = new Rating(article1, 5);
        Rating article1Review2 = new Rating(article1, 4);
        Rating article1Review3 = new Rating(article1, 3);
        DBHelper.save(article1Review1);
        DBHelper.save(article1Review2);
        DBHelper.save(article1Review3);

        Rating article2Review1 = new Rating(article2, 5);
        Rating article2Review2 = new Rating(article2, 2);
        Rating article2Review3 = new Rating(article2, 0);
        DBHelper.save(article2Review1);
        DBHelper.save(article2Review2);
        DBHelper.save(article2Review3);

        Rating article3Review1 = new Rating(article3, 2);
        Rating article3Review2 = new Rating(article3, 5);
        Rating article3Review3 = new Rating(article3, 2);
        DBHelper.save(article3Review1);
        DBHelper.save(article3Review2);
        DBHelper.save(article3Review3);

        Rating article4Review1 = new Rating(article4, 0);
        Rating article4Review2 = new Rating(article4, 0);
        Rating article4Review3 = new Rating(article4, 2);
        DBHelper.save(article4Review1);
        DBHelper.save(article4Review2);
        DBHelper.save(article4Review3);

        Rating article5Review1 = new Rating(article5, 0);
        Rating article5Review2 = new Rating(article5, 0);
        Rating article5Review3 = new Rating(article5, 2);
        DBHelper.save(article5Review1);
        DBHelper.save(article5Review2);
        DBHelper.save(article5Review3);



    }
}
