/**
 * Copyright (C) 2009 - 2013 SC 4ViewSoft SRL
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.esprit.minipo.gui;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer.Orientation;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.views.BarChart;
import com.codename1.charts.views.BarChart.Type;
import com.codename1.ui.Form;
import java.util.ArrayList;
import java.util.List;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.esprit.minipo.entites.Conge;
import com.esprit.minipo.services.ServiceConge;

/**
 * Sales demo bar chart.
 */
public class SalesBarChart extends AbstractDemoChart {

    /**
     * Returns the chart name.
     *
     * @return the chart name
     */
    public String getName() {
        return "Sales horizontal bar chart";
    }

    /**
     * Returns the chart description.
     *
     * @return the chart description
     */
    public String getDesc() {
        return "The monthly sales for the last 2 years (horizontal bar chart)";
    }

    public Component getChartModelEditor() {
        return null;
    }

    public String getChartTitle() {
        return "";
    }

    public Component execute() {
        String[] titles = new String[]{"", ""};
        List<double[]> values = new ArrayList<double[]>();
        
        
        ArrayList<Conge> emp=new ArrayList<Conge>();
    
        emp=ServiceConge.getInstance().getAllConge();
        int j=0;
        double[] val = new double[emp.size()];
         values.add(new double[]{}); 
        int[] colors = new int[]{ColorUtil.BLUE, ColorUtil.CYAN};
        XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);
    
    
           
           for (Conge c : emp) {
                val[j++]=c.getNbrjrs();
                renderer.addXTextLabel(j,c.getType());
    }
           
        values.add(val);
        
        
       /* values.add(new double[]{5230, 7300, 9240, 10540, 7900, 9200, 12030, 11200, 9500, 10500,
            11600, 13500});*/ 
       
        renderer.setOrientation(Orientation.HORIZONTAL);
        setChartSettings(renderer, "nombre de jours conge selon le type", "", "Nombre de jours", 0.5,
                12.5, 0,40, ColorUtil.GRAY, ColorUtil.LTGRAY);
        renderer.setXLabels(1);
        renderer.setYLabels(10);
       renderer.setXLabelsAngle(90);
        initRendererer(renderer);
        int length = renderer.getSeriesRendererCount();
        for (int i = 0; i < length; i++) {
            XYSeriesRenderer seriesRenderer = (XYSeriesRenderer) renderer.getSeriesRendererAt(i);
            seriesRenderer.setDisplayChartValues(true);
        }

        BarChart chart = new BarChart(buildBarDataset(titles, values), renderer,
                Type.DEFAULT);
        return newChart(chart);

    }

}
