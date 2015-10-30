package models.service.Qanda;

import models.entity.Qanda;
import play.db.ebean.Model.Finder;
import models.service.IF.ModelService;
import play.libs.F;
import utils.ModelUtil;
import utils.OptionUtil;

import java.util.List;

import static play.libs.F.*;

public class QandaModelService implements ModelService<Qanda> {

    public static QandaModelService use() {
        return new QandaModelService();
    }

    /**
     * IDで検索
     * @param id
     * @return
     */
    @Override
    public Option<Qanda> findById(Long id) {
        Option<Long> idOps = OptionUtil.apply(id);
        if(idOps.isDefined()) {
            Finder<Long, Qanda> find = ModelUtil.getFinder(Qanda.class);
            return OptionUtil.apply(find.byId(id));
        }
        return new None<Qanda>();
    }

    /**
     * 保存
     * @param entry
     * @return
     */
    @Override
    public Option<Qanda> save(Qanda entry) {
        Option<Qanda> entryOps = OptionUtil.apply(entry);
        if(entryOps.isDefined()) {
            entry.save();
            if(OptionUtil.apply(entry.getId()).isDefined()) {
                return OptionUtil.apply(entry);
            }
        }
        return new None<Qanda>();
    }

    @Override
    public Option<Qanda> delete(Long id){
      return null;
    }
    @Override
    public Option<Qanda> deleteAll(List<Long> id){
      return null;

    }
}
