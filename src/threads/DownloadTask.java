package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DownloadTask implements Callable<String> {

    private String fileUrl;

    public DownloadTask(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    // method to download file task
    @Override
    public String call() throws Exception {
        System.out.println("Started downloading file...");
        Thread.sleep(2000);
        System.out.println("Downloading has finished...");
        return "Downloaded file from URL: " + fileUrl;
    }

    public static void main(String[] args) {

        //array of 10 url
        String[] fileUrl = {
                "https://example.com/file1",
                "https://example.com/file2",
                "https://example.com/file3",
                "https://example.com/file4",
                "https://example.com/file5",
                "https://example.com/file6",
                "https://example.com/file7",
                "https://example.com/file8",
                "https://example.com/file9",
                "https://example.com/file10"
        };

        //fixed size of threadpool
        ExecutorService service = Executors.newFixedThreadPool(4);

        List <Future<String>> futures = new ArrayList<>();

        for (String url: fileUrl) {
            Callable<String> downloadTask = new DownloadTask(url);
            Future<String> future = service.submit(downloadTask);
            futures.add(future);
        }

        for (Future<String> future: futures) {
            try {
                String result = future.get();
                System.out.println("result = " + result);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }

        service.shutdown();

    }
}
