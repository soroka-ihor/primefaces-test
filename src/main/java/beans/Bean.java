package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Model;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ManagedBean
@SessionScoped
public class Bean {

    private String value;
    private String required;
    private String selectedModelValue;
    private List<Model> models;

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
        value = "";
        models = new ArrayList<Model>();
        models.add(new Model(1, "First model value"));
        models.add(new Model(2, "Second model value"));
    }

    public boolean disabled() {
        if (!value.equals("")) {
            if (selectedModelValue != null) {
                return false;
            }
        }
        return true;
    }

    public void handleValueChangeListener(ValueChangeEvent event) {
        if (event.getNewValue() == null) {
            selectedModelValue = null;
        }
    }

    public void subjectSelectionChanged(final AjaxBehaviorEvent event)  {

    }
}
