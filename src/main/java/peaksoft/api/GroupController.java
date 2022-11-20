package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import peaksoft.model.Group;
import peaksoft.service.GroupService;

@Controller
public class GroupController {
    private final GroupService groupService;


    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups/{id}")
    public String getAllGroups(@PathVariable Long id, Model model) {
        model.addAttribute("groups", groupService.getAllGroup());
        model.addAttribute("companyId", id);
        return "/course/all_courses";
    }

    @GetMapping("/groups/{id}/addGroup")
    public String addGroup(@PathVariable Long id, Model model) {
        model.addAttribute("group", new Group());
        model.addAttribute("companyId", id);
        return "/group/add_group";
    }

    @PostMapping("/{id}/saveGroup")
    public String saveGroup(@ModelAttribute("group") Group group,
                            @PathVariable Long id) {
        groupService.addGroup(id, group);
        return "redirect:/all_courses/" + id;
    }

    @GetMapping("/updateGroup/{id}")
    public String updateGroup(@PathVariable("id") Long id, Model model) {
        Group group = groupService.getGroupById(id);
        model.addAttribute("group", group);
        model.addAttribute("companyId", group.getCompany().getId());
        return "/group/update_group";
    }

    @PostMapping("/{companyId}/{id}/saveUpdateGroup")
    public String saveUpdateCourse(@PathVariable("companyId") Long companyId,
                                   @PathVariable("id") Long id,
                                   @ModelAttribute("group") Group group) {
        groupService.updateGroup(group,id);
        return "redirect:/courses/"+companyId;
    }

//    @GetMapping("/update/{id}")
//    public String updateGroup(@PathVariable("id") Long id, Model model) {
//        Group group = groupService.getGroupById(id);
//        model.addAttribute("group", group);
//        return "/group/update_group";
//    }
//
//    @PostMapping("/{courseId}/{id}/saveUpdateGroup")
//    public String saveUpdateGroup(@PathVariable("courseId") Long courseId, @PathVariable("id") Long id,
//                                  @ModelAttribute("group") Group group) {
//        groupService.updateGroup(group, id);
//        return "redirect:/groups/"+courseId;
//    }

    @GetMapping("/{companyId}/{id}/deleteGroup")
    public String deleteGroup(@PathVariable("id") Long id, @PathVariable("companyId") Long companyId) {
        groupService.deleteGroup(id);
        return "redirect:/courses/" + companyId;
    }
}