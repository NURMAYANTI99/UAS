package simple.example.hewanpedia;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import simple.example.hewanpedia.model.Hewan;
import simple.example.hewanpedia.model.Harimau;
import simple.example.hewanpedia.model.Kumbang;
import simple.example.hewanpedia.model.Tikus;

public class DataProvider {
    private static List<Hewan> hewans = new ArrayList<>();

    private static List<Harimau> initDataHarimau(Context ctx) {
        List<Harimau> harimaus = new ArrayList<>();
        harimaus.add(new Harimau(ctx.getString(R.string.katanga_nama), ctx.getString(R.string.katanga_asal),
                ctx.getString(R.string.katanga_deskripsi), R.drawable.harimau1));
        harimaus.add(new Harimau(ctx.getString(R.string.kongo_nama), ctx.getString(R.string.kongo_asal),
                ctx.getString(R.string.kongo_deskripsi), R.drawable.harimau2));
        harimaus.add(new Harimau(ctx.getString(R.string.transval_nama), ctx.getString(R.string.transval_asal),
                ctx.getString(R.string.transval_deskripsi), R.drawable.harimau3));
        harimaus.add(new Harimau(ctx.getString(R.string.barbary_nama), ctx.getString(R.string.barbary_asal),
                ctx.getString(R.string.barbary_deskripsi), R.drawable.harimau4));
        harimaus.add(new Harimau(ctx.getString(R.string.afrika_timur_nama), ctx.getString(R.string.afrika_timur_asal),
                ctx.getString(R.string.afrika_timur_deskripsi), R.drawable.harimau5));
        harimaus.add(new Harimau(ctx.getString(R.string.asia_nama), ctx.getString(R.string.asia_asal),
                ctx.getString(R.string.asia_deskripsi), R.drawable.harimau6));
        return harimaus;
    }

    private static List<Kumbang> initDataKumbang(Context ctx) {
        List<Kumbang> kumbangs = new ArrayList<>();
        kumbangs.add(new Kumbang(ctx.getString(R.string.srilanka_nama), ctx.getString(R.string.srilanka_asal),
                ctx.getString(R.string.srilanka_deskripsi), R.drawable.kum1));
        kumbangs.add(new Kumbang(ctx.getString(R.string.jawa_nama), ctx.getString(R.string.jawa_asal),
                ctx.getString(R.string.jawa_deskripsi), R.drawable.kum2));
        kumbangs.add(new Kumbang(ctx.getString(R.string.indochina_nama), ctx.getString(R.string.indochina_asal),
                ctx.getString(R.string.indochina_deskripsi), R.drawable.kum3));
        kumbangs.add(new Kumbang(ctx.getString(R.string.amur_nama), ctx.getString(R.string.amur_asal),
                ctx.getString(R.string.amur_deskripsi), R.drawable.kum4));
        kumbangs.add(new Kumbang(ctx.getString(R.string.cina_utara_nama), ctx.getString(R.string.cina_utara_asal),
                ctx.getString(R.string.cina_utara_deskripsi), R.drawable.kum5));
        kumbangs.add(new Kumbang(ctx.getString(R.string.persia_nama), ctx.getString(R.string.persia_asal),
                ctx.getString(R.string.persia_deskripsi), R.drawable.kum6));
        return kumbangs;
    }

    private static List<Tikus> initDataTikus(Context ctx) {
        List<Tikus> tikuss = new ArrayList<>();
        tikuss.add(new Tikus(ctx.getString(R.string.bengal_nama), ctx.getString(R.string.bengal_asal),
                ctx.getString(R.string.bengal_deskripsi), R.drawable.tikus1));
        tikuss.add(new Tikus(ctx.getString(R.string.indocina_nama), ctx.getString(R.string.indocina_asal),
                ctx.getString(R.string.indocina_deskripsi), R.drawable.tikus2));
        tikuss.add(new Tikus(ctx.getString(R.string.malaya_nama), ctx.getString(R.string.malaya_asal),
                ctx.getString(R.string.malaya_deskripsi), R.drawable.tikus3));
        tikuss.add(new Tikus(ctx.getString(R.string.sumatera_nama), ctx.getString(R.string.sumatera_asal),
                ctx.getString(R.string.sumatera_deskripsi), R.drawable.tikus4));
        tikuss.add(new Tikus(ctx.getString(R.string.siberia_nama), ctx.getString(R.string.siberia_asal),
                ctx.getString(R.string.siberia_deskripsi), R.drawable.tikus5));
        tikuss.add(new Tikus(ctx.getString(R.string.cina_selatan_nama), ctx.getString(R.string.cina_selatan_asal),
                ctx.getString(R.string.cina_selatan_deskripsi), R.drawable.tikus6));
        return tikuss;
    }

    private static void initAllHewans(Context ctx) {
        hewans.addAll(initDataHarimau(ctx));
        hewans.addAll(initDataKumbang(ctx));
        hewans.addAll(initDataTikus(ctx));
    }

    public static List<Hewan> getAllHewan(Context ctx) {
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        return  hewans;
    }

    public static List<Hewan> getHewansByTipe(Context ctx, String jenis) {
        List<Hewan> hewansByType = new ArrayList<>();
        if (hewans.size() == 0) {
            initAllHewans(ctx);
        }
        for (Hewan h : hewans) {
            if (h.getJenis().equals(jenis)) {
                hewansByType.add(h);
            }
        }
        return hewansByType;
    }

}
