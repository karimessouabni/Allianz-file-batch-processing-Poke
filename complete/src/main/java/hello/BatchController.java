package hello;


import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BatchController {

    // Spring Batch jobLancher
    private JobLauncher jobLauncher;

    // the csv processing job
    private Job myJob;

    @Autowired
    public BatchController(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.myJob = job;
    }

    @PostMapping("/")
    public void launchJob() throws Exception {

        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .addDate("execution date ", new Date())
                .toJobParameters();
        jobLauncher.run(myJob, params);

    }
}

