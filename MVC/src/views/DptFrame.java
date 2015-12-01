package views;

import models.Etudiant;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Marc-Antoine on 01/12/2015.
 */
public class DptFrame extends JInternalFrame {

    private ArrayList<Etudiant> dataList;
    private DptChart chart;

    public DptFrame(ArrayList<Etudiant> dataList) {
        this.dataList = dataList;

        chart = new DptChart();
        this.add(chart);

        this.setVisible(true);
        this.pack();
    }


    private class DptChart extends JPanel{

        private ArrayList<String> tmp;

        public DptChart(){

            final PieDataset dataset = createDataset();

            final JFreeChart chart = createChart(dataset, "Répartition Géographique", "No data to display");

            // add the chart to a panel...
            final ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            this.add(chartPanel);
        }

        private PieDataset createDataset() {

            final DefaultPieDataset result = new DefaultPieDataset();
            tmp = new ArrayList<>();

            /* Get list of dpts */

            for (Etudiant aTmp : dataList) {
                if(!tmp.contains(aTmp.getDpt()))
                    tmp.add(aTmp.getDpt());
            }

            for (String aTmp : tmp) result.setValue(aTmp, countFrequency(aTmp));

            return result;
        }

        private double countFrequency(String aTmp) {
            double nb = 0;

            for(Etudiant etuTmp : dataList) {
                if(etuTmp.getDpt().equals(aTmp)) nb++;
            }
            return nb;
        }

        private JFreeChart createChart(final PieDataset dataset, String chartTitle, String noDataMessage) {

            final JFreeChart chart = ChartFactory.createPieChart3D(
                    chartTitle,  // chart title
                    dataset,                // data
                    false,                   // include legend
                    true,
                    false
            );

            final PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(290);
            plot.setDirection(Rotation.CLOCKWISE);
            plot.setForegroundAlpha(0.5f);
            plot.setNoDataMessage(noDataMessage);
            return chart;
        }
    }
}
