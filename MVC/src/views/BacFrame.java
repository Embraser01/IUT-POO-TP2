package views;

import models.Etudiant;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 */
public class BacFrame extends JInternalFrame implements Observateur {

    private ArrayList<Etudiant> dataList;
    private BacChart chart;

    public BacFrame(ArrayList<Etudiant> dataList) {
        super("Filières");
        this.dataList = dataList;

        chart = new BacChart();
        this.add(chart);

        this.setVisible(true);
        this.pack();
    }

    @Override
    public void onUpdate() {
        chart = new BacChart();
    }


    private class BacChart extends JPanel {

        private ArrayList<String> tmp;

        public BacChart() {

            final CategoryDataset dataset = createDataset();

            // create the chart...
            final JFreeChart chart = createCategoryChart(dataset, title, "Bacs", "Nombre", PlotOrientation.VERTICAL);

            // add the chart to a panel...
            final ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            this.add(chartPanel);
        }

        private CategoryDataset createDataset() {

            final DefaultCategoryDataset dataset=new DefaultCategoryDataset();
            tmp = new ArrayList<>();

            /* Get list of series */

            for (Etudiant aTmp : dataList) {
                if(!tmp.contains(aTmp.getSerieBac()))
                    tmp.add(aTmp.getSerieBac());
            }
            for (String aTmp : tmp) dataset.setValue(countFrequency(aTmp), aTmp, aTmp);

            return dataset;
        }

        private double countFrequency(String aTmp) {
            double nb = 0;

            for(Etudiant etuTmp : dataList) {
                if(etuTmp.getSerieBac().equals(aTmp)) nb++;
            }
            return nb;
        }


        private JFreeChart createCategoryChart(final CategoryDataset dataset, String title, String domain, String range, PlotOrientation orientation) {

            final JFreeChart chart = ChartFactory.createBarChart3D(
                    title,      // chart title
                    domain,               // domain axis label
                    range,                 // range axis label
                    dataset,                  // data
                    orientation, // orientation
                    true,                     // include legend
                    true,                     // tooltips
                    false                     // urls
            );

            final CategoryPlot plot = chart.getCategoryPlot();
            final CategoryAxis axis = plot.getDomainAxis();
            axis.setCategoryLabelPositions(
                    CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
            );

            final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
            renderer.setDrawBarOutline(false);

            return chart;
        }
    }
}
