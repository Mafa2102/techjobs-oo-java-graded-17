package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @SuppressWarnings("unchecked")

    @Test
    public void emptyTest(){

    }
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test

    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        // creating two Job objects that have identical field values EXCEPT for id
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job3, job4);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //assertEquals('\n', job5.toString().charAt(0));
        //assertEquals('\n', job5.toString().charAt(job5.toString().length()-1));
        String jobStr = job5.toString();
        assertEquals(System.lineSeparator(), jobStr.substring(0, System.lineSeparator().length()));
        assertEquals(System.lineSeparator(), jobStr.substring(jobStr.length() - System.lineSeparator().length()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String result = System.lineSeparator() +
                "ID: " + job6.getId() + System.lineSeparator() +
                        "Name: " + job6.getName() + System.lineSeparator() +
                        "Employer: " + job6.getEmployer() + System.lineSeparator() +
                        "Location: " + job6.getLocation() + System.lineSeparator() +
                        "Position Type: "  + job6.getPositionType() + System.lineSeparator() +
                        "Core Competency: " + job6.getCoreCompetency() + System.lineSeparator();

        assertEquals(result, job6.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job7 = new Job("", new Employer("ACME"), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue(job7.toString().contains("Data not available"));

    }

//    @Test
//    public void testToStringHandlesEmptyField() {
//        Job job_eight = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//
//        String output =
//
//                "\nID: " + job_eight.getId() +
//                        "\nName: " + job_eight.getName() +
//                        "\nEmployer: " + "Data not available" +
//                        "\nLocation: "  + job_eight.getLocation() +
//                        "\nPosition Type: "  + job_eight.getPositionType() +
//                        "\nCore Competency: " + job_eight.getCoreCompetency() + "\n";
//
//        assertEquals(output, job_eight.toString());
//
//        assertEquals("Data not available", job_eight.getEmployer().toString());
//    }

    @Test
    public void oopsBonus(){
        Job job8 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertTrue(job8.toString().contains("OOPS! This job does not seem to exist."));
    }
}
